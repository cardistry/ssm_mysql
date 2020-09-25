package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();

    public int login(String userName,String password){
        String sql = "select count(*) from users where userName = ? " +
                "and password = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet result = null;
        int rs = 0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            result = ps.executeQuery();
            while (result.next()){
               rs =  result.getInt("count(*)");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
           util.close(result);
        }
        return rs;
    }
    public int delete(String userId) {
        String sql = "delete from users where userId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    public List findAll(){
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;

        List<Users> userList = new ArrayList<Users>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users user = new Users(userId,userName,password,sex,email);
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return userList;
    }

    //用户注册

    public int add(Users user){
        String sql = "insert into users(userName,password,sex,email)" +
                     " values (?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    public int add(Users user, HttpServletRequest request){
        String sql = "insert into users(userName,password,sex,email)" +
                " values (?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);
        int result = 0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
}

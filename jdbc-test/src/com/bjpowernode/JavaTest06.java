package com.bjpowernode;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaTest06{
    public static void main(String[] args) {
        //初始化界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        if(loginSuccess){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败哦");
        }
    }

    private static boolean login(Map<String, String> userLoginInfo) {
        boolean loginSuccess = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode",
                    "root", "root");
            stmt = conn.createStatement();
            String sql = "select * from t_user where login_name  = '"+loginName+"' and login_passswd  = '"+loginPwd+"' ";
            res = stmt.executeQuery(sql);
            if(res.next())
                loginSuccess = true;

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }        finally {
            if(res != null){
                try {
                    res.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }


        }
         return loginSuccess;
    }

    private static Map<String,String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名： ");
        String loginName = s.nextLine();
        System.out.println("密码： ");
        String loginPwd = s.nextLine();
        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);
        return userLoginInfo;
    }
}
package com.bjpowernode.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilTest {
    public static void main(String[] args) {
        Connection conn =  null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = DBUtil.getConnnection();
            String sql = "select ename from emp where ename like ?";
            ps = conn.prepareStatement(sql);;
            ps.setString(1,"_A%");
            res = ps.executeQuery();
            while (res.next()){
                System.out.println(res.getString("ename"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,res);
        }
    }
}

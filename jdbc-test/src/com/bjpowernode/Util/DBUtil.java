package com.bjpowernode.Util;

import java.sql.*;

//简化jdbc 编程
public class DBUtil {
    //工具类中的方法都是private 的，因为需要使用类方法，不需要new 对象

    private  DBUtil(){};
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode",
                "root", "root");
    }
    public static void close(Connection conn, Statement ps, ResultSet res){
        if(res != null){
            try {
                res.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
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


}


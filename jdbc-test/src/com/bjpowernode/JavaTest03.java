package com.bjpowernode;
//注册的另一种方式
import java.sql.*;

public class JavaTest03 {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String passwd = "root";
            // 2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode",
                    "root", "root");
            System.out.println(conn);


        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

package com.bjpowernode;

import java.sql.*;

public class JavaTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            // 1、注册驱动
            Driver driver = new com.mysql.cj.jdbc.Driver();

            DriverManager.registerDriver(driver);

            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String passwd = "root";
            String sql = "delete from dept where deptno = 50";
            // 2、获取连接
            conn = DriverManager.getConnection(url,user,passwd);
            //3、获取数据库操作对象
            statement = conn.createStatement();
            // 4、执行sql语句
            int count = statement.executeUpdate(sql);
            System.out.println(count  == 1 ? "删除成功":"删除失败");
            // 5、获取查询结果集

        }catch (SQLException e){
             e.printStackTrace();
        }finally {
            // 6、释放资源
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

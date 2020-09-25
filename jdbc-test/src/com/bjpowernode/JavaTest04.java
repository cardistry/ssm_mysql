package com.bjpowernode;
//使用资源绑定器
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JavaTest04 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String user = bundle.getString("user");
        String url = bundle.getString("url");
        String passwd = bundle.getString("password");
        Connection conn = null;
        Statement statement = null;
        try {
            // 1、注册驱动
            Class.forName(driver);


            // 2、获取连接
            conn = DriverManager.getConnection(url,user,passwd);
            //3、获取数据库操作对象

            statement = conn.createStatement();
            // 4、执行sql语句
            int count = statement.executeUpdate("insert into dept(deptno,dname,loc)values(50,'人事部','北京');");
            System.out.println(count  == 1 ? "删除成功":"删除失败");
            // 5、获取查询结果集

        }catch (SQLException e){
             e.printStackTrace();
        }catch (ClassNotFoundException e){
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

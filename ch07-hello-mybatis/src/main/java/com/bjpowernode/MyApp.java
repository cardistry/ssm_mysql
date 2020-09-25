package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class  MyApp {
    public static void main(String[] args) throws IOException {
        //1.定义mybatis 主配置文件的名称，从类的根路径开始
        String config = "mybatis.xml";
        //2.读取主配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了  SqlSessionFactoryBuilder  对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建了SqlSessionFactory  对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取 sqlSession 对象，从SqlSessionFactory 中获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句的标识  sql 映射文件中的namespace + '.' + 标签的id 值
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        //7.执行sql 语句，通过sqlId 找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

}

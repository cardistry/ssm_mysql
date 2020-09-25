package com;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis  {
    @Test
    public void testInsert  () throws IOException {
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
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "insertStudents";
        //7.执行sql 语句，通过sqlId 找到语句
        Student student = new Student();
        student.setId(1003);
        student.setName("张飞");
        student.setEmail("zhangfei@163.com");
        student.setAge(19);
        System.out.println("执行insert 方法");
        int count = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        //8.输出结果
        System.out.println(count);
        sqlSession.close();
    }
}

package com.bjpowernode;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mybatis_utils_test {
    @Test
    public void testSelectStudents(){
       /* 使用mybatis 的动态代理机制，使用sqlSession.getMapper(dao 接口)
                getMapper能获取dao 接口对于的实现类对象*/
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
//        调用dao 的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for(Student student : students){
            System.out.println("学生 = " + student);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(11);
        student.setEmail("dunshan@qq.com");
        student.setId(1005);
        student.setName("猴子");
        int count = dao.insertStudents(student);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("添加对象的数量是" + count);

    }


}

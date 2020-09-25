package com.bjpowernode;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.ViewStudent;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mybatis_utils_test {
    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentById(1003);
        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectMuliParm(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMuliParm("张三",20);

        for(Student student : students){
            System.out.println("学生 = " + student);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectStudentReturnViewStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<ViewStudent> students = dao.selectStudentReturnViewStudent(1003);

        for(ViewStudent student : students){
            System.out.println("学生 = " + student);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testCountStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int count = dao.countStudent();
        System.out.println("学生的数目实施： "+count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectAllStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);

        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void selectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);

        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

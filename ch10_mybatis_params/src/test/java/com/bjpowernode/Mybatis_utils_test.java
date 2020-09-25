package com.bjpowernode;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.QueryParam;
import com.bjpowernode.domain.Student;
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
    public void testselectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParaAge(11);
        param.setParaName("张三");
        List<Student> students = dao.selectMultiObject(param);
        for(Student param1 : students){
            System.out.println("学生 = " + param1);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

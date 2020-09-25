package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Mybatis_utils_test {
    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
//        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentIf(student);
        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
//        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentWhere(student);
        for(Student stu: students){
            System.out.println("student = " + stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFor(){
        List <Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        String sql = "select * from student where id in";
        StringBuilder builder = new StringBuilder("");
        int init = 0;
        int len = list.size();
        builder.append("(");
        for(Integer i : list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql += builder.toString();
        System.out.println("sql == " + sql);
    }

    @Test
    public void TestSelectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List <Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        for(Student student:students){
            System.out.println("foreach-one ==" + student);
        }

    }

    @Test
    public void TestSelectForeachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1001);
        Student student2 = new Student();
        student2.setId(1002);
        studentList.add(student1);
        studentList.add(student2);
        List<Student> students = dao.selectForeachTwo(studentList);
        for(Student student:students){
            System.out.println("foreach-one ==" + student);
        }

    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<>();
        //加入pagehelper 分页
//      pageNum 第几页  pageSize 一页有多少行数据
        PageHelper.startPage(1,3);
        List<Student> students = dao.selectAll();
        for(Student student:students){
            System.out.println("foreach-one ==" + student);
        }
    }

    @Test
    public void test(){
        String string = "123";
        String substr = string.substring(1,3);
        System.out.println(substr);
    }

}

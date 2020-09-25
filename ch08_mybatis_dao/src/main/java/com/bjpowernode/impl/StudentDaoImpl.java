package com.bjpowernode.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //获取sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
        return studentList;
    }
    @Override
    public int insertStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student student = new Student();
        student.setAge(11);
        student.setEmail("dunshan@qq.com");
        student.setId(1004);
        student.setName("顿山");
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "insertStudents";
        int count = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}

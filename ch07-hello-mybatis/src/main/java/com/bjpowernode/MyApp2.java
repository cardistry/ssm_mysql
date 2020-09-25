package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyApp2 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }
}

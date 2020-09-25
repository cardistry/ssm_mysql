package com.bjpowernode;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

public class Mybatis_utils_test {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertStudents() {
        StudentDao dao = new StudentDaoImpl();
        int count  = dao.insertStudents();
        System.out.println(count);
    }

}

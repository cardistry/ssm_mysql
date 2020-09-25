package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface OrderDao {
        int insertstudent(Student student);
        List<Student> selectStudent();
}

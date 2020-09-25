package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//接口操作student 表
public interface StudentDao {
     public List<Student> selectStudents();
     //返回Inset后影响表的行数
     public int insertStudent(Student student);
}

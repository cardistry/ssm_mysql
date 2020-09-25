package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//接口操作student 表
public interface StudentDao {
     public List<Student> selectStudents();
     public int insertStudents(Student student);


}

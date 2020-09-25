package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//接口操作student 表
public interface StudentDao {
//动态sql，使用java 对象作为参数
    List<Student> selectStudentIf(Student student);
//    动态sql 之where 的使用
    List<Student> selectStudentWhere(Student student);

//    foreach 的使用
    List<Student> selectForeachOne(List<Integer> idList);
// foreach 成员是对象
    List<Student> selectForeachTwo(List<Student> studentList);

    List<Student> selectAll();

}

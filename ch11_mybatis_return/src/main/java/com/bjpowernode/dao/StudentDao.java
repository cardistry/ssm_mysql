package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//接口操作student 表
public interface StudentDao {
     public List<Student> selectStudentById(int id);

     List<Student> selectMuliParm(@Param("myname") String name, @Param("myage") Integer age);

     List<ViewStudent> selectStudentReturnViewStudent(@Param("sId") Integer id);

     int countStudent();

     List<Student> selectAllStudent();

     //第一种模糊查询，在第一种java 代码中指定like 的内容
     List<Student>  selectLikeOne(String name);

     //第二种模糊查询，在mapper 中拼接 like "%" 李 "%"
     List<Student>  selectLikeTwo(String name);

}

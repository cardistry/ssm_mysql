package com.bjpowernode.dao;

import com.bjpowernode.domain.QueryParam;
import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//接口操作student 表
public interface StudentDao {
     public List<Student> selectStudentById(int id);
     //传递多个参数  parm 命名参数
     List<Student> selectMuliParm(@Param("myname") String name, @Param("myage") Integer age);

     //多个参数,使用java 对象作为接口方法中的参数
     List<Student> selectMultiObject(QueryParam param);
}

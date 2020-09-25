package com.bjpowernode.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    @Value(value = "张飞")
    public String name;
    public  Integer age;
    @Autowired (required = false) //(true 类型赋值失败,程序报错,终止执行 false 类型赋值失败,程序正常赋值null,大多数情况使用true  )//按类型注入
    @Qualifier(value = "mySchool")
    private School school;

    public void setName(String name) {
        this.name = name;
    }
    @Value(value = "23")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}

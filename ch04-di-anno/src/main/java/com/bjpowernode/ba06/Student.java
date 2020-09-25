package com.bjpowernode.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    @Value(value = "张飞")
    public String name;
    public  Integer age;
    //@Resource 来自jdk 的注解,spring 也提供对他的支持,可以对引用类型赋值,
    // 也是自动注入原理,支持byName,byType,默认是byName,如果byName 失败就会尝试byType
//    @Resource(name = "school")  这样可以只使用byName
    //jdk 13 没有这个注解
    //@resource
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

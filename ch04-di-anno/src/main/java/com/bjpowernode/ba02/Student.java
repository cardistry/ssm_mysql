package com.bjpowernode.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    @Value(value = "张飞")
    public String name;

    public  Integer age;

    public void setName(String name) {
        this.name = name;
    }
    @Value(value = "23")
    public void setAge(Integer age) {
        this.age = age;
    }
}

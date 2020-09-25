package com.bjpowernode.vo;

public class Student {
    private String name;
    private Integer age;

    public void setName(String name) {
        System.out.println("setName" + name);
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("setAge" + age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }


    public Student() {
        System.out.println("Student 的无参构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

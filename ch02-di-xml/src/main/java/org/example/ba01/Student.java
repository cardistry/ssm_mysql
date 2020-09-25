package org.example.ba01;

public class Student {

    public String name;
    public int age;

    public void setName(String name) {
        System.out.println("setName " + name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setAge " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package org.example.ba02;


public class Student {

    public String name;
    public int age;
    private School school;

    public void setName(String name) {
        System.out.println("setName " + name);
        this.name = name;
    }

    public void setSchool(School school) {
        System.out.println("set school : " + school);
        this.school = school;
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
                ", school=" + school +
                '}';
    }
}


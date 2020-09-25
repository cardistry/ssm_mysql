package org.example.ba03;


public class Student {

    public String name;
    public int age;
    private School school;
    public Student(String name, int age, School school) {
        System.out.println("=== student 的有参构造器 ===");
        this.name = name;
        this.age = age;
        this.school = school;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(School school) {
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


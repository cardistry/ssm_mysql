package org.example.ba04;


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

//    public Student(String name, int age, School school) {
//        this.name = name;
//        this.age = age;
//        this.school = school;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}


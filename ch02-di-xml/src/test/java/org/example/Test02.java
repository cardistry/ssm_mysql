package org.example;

import org.example.ba02.School;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        //创建对象,默认调用的是类的无参构造方法
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student 对象
        Student myStudent = (Student) ac.getBean("myStudent2");
        System.out.println("student 对象 = " +myStudent);
    }




    @Test
    public void test02(){
        System.out.println("=== test02 ===");
        Student student  = new Student();
        student.setAge(11);
        student.setName("ahui");

        School school = new School();
        school.setAddress("沈阳");
        school.setName("计算技术研究所");

        student.setSchool(school);

    }
}

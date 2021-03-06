package org.example;

import org.example.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    @Test
    public void test01(){
        String config = "ba04/applicationContext.xml";
        //创建对象,默认调用的是类的无参构造方法
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student 对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("student 对象 = " +myStudent);
    }
}

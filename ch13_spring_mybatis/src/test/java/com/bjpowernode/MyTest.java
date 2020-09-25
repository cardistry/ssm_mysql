package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象名称： " + na + "|" + ctx.getBean(na));
        }
    }

    @Test
    public void testInsertStudent(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1003);
        student.setAge(20);
        student.setEmail("zhoufeng@qq.com");
        student.setName("周峰");
        int count = dao.insertStudent(student);
        System.out.println("插入成功" + count );
    }
}

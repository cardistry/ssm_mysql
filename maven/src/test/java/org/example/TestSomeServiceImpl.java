package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestSomeServiceImpl {
    @Test
    public void test01(){
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }
    @Test
    public void test02() {
        String config = "beans.xml";
        //创建对象,默认调用的是类的无参构造方法
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //读取对象
        SomeService service = (SomeService) ac.getBean("someService");
        service.doSome();

    }

    //获取类文件信息
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        int nums = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量" + nums);
        String [] names = ac.getBeanDefinitionNames();
        for(String name:names)
            System.out.println(name);
    }
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date date = (Date)ac.getBean("mydate");
        System.out.println("Date " + date);
    }
}

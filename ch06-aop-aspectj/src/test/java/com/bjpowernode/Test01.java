package com.bjpowernode;

import com.bjpowernode.ba01.SomeServiceImpl2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
//    @Test
//    public void test1(){
//        String config = "applicationContext.xml";
//        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//
//        SomeService proxy = (SomeService)ac.getBean("SomeService");
//        System.out.println("proxy 的类型" + proxy.getClass().getName());
//        System.out.println(proxy.doOther("lisa",13));
//
//    }
//    @Test
//    public void test2(){
//        String config = "applicationContext.xml";
//        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//
//        SomeService proxy = (SomeService)ac.getBean("SomeService");
//        System.out.println("proxy 的类型" + proxy.getClass().getName());
//        System.out.println(proxy.doFirst("lisa",13));
//
//    }

    @Test
    public void test3() {
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        SomeServiceImpl2 proxy = (SomeServiceImpl2)ac.getBean("SomeService");
        System.out.println("proxy 的类型" + proxy.getClass().getName());
        proxy.doSome("lisa",13);
    }
}

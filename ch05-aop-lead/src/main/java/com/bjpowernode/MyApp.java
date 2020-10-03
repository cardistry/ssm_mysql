package com.bjpowernode;

import com.bjpowernode.handler.MyIncationHandler;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {

        SomeService target = new SomeServiceImpl();

        //使用InovationHandler对象
        InvocationHandler handler = new MyIncationHandler(target);
        //使用jdk的Proxy 创建代理对象
        SomeService proxy =  (SomeService)Proxy.newProxyInstance(
                                target.getClass().getClassLoader(),
                                target.getClass().getInterfaces(),handler);

        proxy.doSome();



    }
}

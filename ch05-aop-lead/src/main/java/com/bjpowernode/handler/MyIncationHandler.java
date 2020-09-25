package com.bjpowernode.handler;

import com.bjpowernode.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    //目标对象 SomeServiceImpl 类
    private Object target;
    public MyIncationHandler(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("执行 MyIncationHandler 中的invoke　方法");
        Object res = null;
        ServiceTools.doLog();
        //通过代理对象执行方法时,会调用这个invoke();
        //执行目标类的方法,通过Method 类实现
        res = method.invoke(target,args);  //SomeServiceImpl.doOther(),doSome()
        ServiceTools.doTrans();
        return  res;
    }
}

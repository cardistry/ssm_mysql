package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("执行了实现类的无参构造方法");
    }
    public void doSome() {
        System.out.println("执行了SomeServiceImpl 的doSome() 方法");
        
    }
}

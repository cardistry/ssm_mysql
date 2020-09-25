package com.bjpowernode.ba01;

//目标类
public class SomeServiceImpl implements SomeService {
    //增加输出时间功能
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("目标方法doSome()");
    }

    @Override
    public String doOther(String name, Integer age){
        System.out.println("目标方法 doOther()");
        return ("目标方法 doOther() 返回值");
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("=== 业务方法 === doFirst()");
        return null;
    }


}

package com.bjpowernode.utils;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法: 当前时间" + new Date());
    }
    public  static void doTrans(){
        System.out.println("提交事务");
    }
}

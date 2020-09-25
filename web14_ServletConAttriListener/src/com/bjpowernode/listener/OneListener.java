package com.bjpowernode.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
    //增加共享数据
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("创建了一个共享对象");
    }
//    删除共享数据
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("销毁了一个共享数据");
    }
    //更新共享数据
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("修改了一个共享数据");
    }
}

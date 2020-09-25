package com.bjpowernode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("恭喜恭喜，来世走一遭");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("兄弟不要怕，二十年后有时一条好汉");
    }
}

package com.bjpowernode.listener;

import com.bjpowernode.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    //在tomcat 启动时，预先创建20个Connection，在userDao.add方法执行时
    //将实现创建好的connection交给add 方法

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util = new JdbcUtil();
        Map map = new HashMap();
        for(int i = 0; i < 20; ++i){
            Connection con = util.getCon();
            System.out.println("在http 服务器启动时，创建connection" +con);
            map.put(con,true);   //true 表示处于空闲状态
        }
        ServletContext application =  sce.getServletContext();
        application.setAttribute("key1",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application =  sce.getServletContext();
        Map map = (Map)application.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection connection = (Connection)it.next();
            if(connection != null){
                System.out.println("兄弟们，我" + connection + "先行一步");
            }

        }
    }
}

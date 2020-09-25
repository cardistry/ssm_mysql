package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//创建一个类继承HttpServlet类，使其成为一个servlet接口的实现类
//重写HttpServlet类父类的两个方法，doGet 和doPost
//将Servelet接口实现类信息主测到tomcat 服务器
public class OneServlet extends HttpServlet {

    public OneServlet(){
        System.out.println("Oneservlet 对象被创建");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServelet类针对浏览器发动Get方法处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServelet类针对浏览器发动Post方法处理");
    }
}

package com.bjpowernode.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//利用ServletContex共享要求在同一个网站下
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象向tomcat索要当前网站的全局作用域对象
        ServletContext application = request.getServletContext();
        //从全局作用域对象中获取指定关键字对应的值
        Integer money = (Integer) application.getAttribute("key1");
        System.out.println(money);
    }
}

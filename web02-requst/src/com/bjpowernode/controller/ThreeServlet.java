package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*请求头中的参数由tomcat 解码 默认utf8解码
请求体的参数由requst 解码,默认iso编码*/
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从请求头中获得参数

        String userName = req.getParameter("userName");
        System.out.println("从请求头中获得参数: " +userName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从请求体中获得参数
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        System.out.println("从请求体中获得参数: " +userName);
    }
}




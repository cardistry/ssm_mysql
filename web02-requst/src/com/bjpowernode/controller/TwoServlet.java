package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        通过请求头获得所有的请求参数名
        Enumeration paraNames = req.getParameterNames();
        while (paraNames.hasMoreElements()) {
            String paramName = (String) paraNames.nextElement();
            System.out.println("请求参数: " + paramName);
        }
    }
}

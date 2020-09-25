package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求对象,读取请求行的url ,uri 和method 属性.
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI().toString();
        String method = req.getMethod();
        System.out.println("uri: "+uri);
        System.out.println("url: " +url);
        System.out.println("method: "+method);
    }
}

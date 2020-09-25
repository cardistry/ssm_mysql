package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FourServlet extends HttpServlet {
       //浏览器接受100 展示d,原因 out.write 功能是将字符,字符串,ascll码写入响应体
//    解决方法,out.print(result)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 100;

        PrintWriter out = resp.getWriter();

        out.print(result);
        System.out.println("FourServelet类针对浏览器发动Get方法处理");
    }
}

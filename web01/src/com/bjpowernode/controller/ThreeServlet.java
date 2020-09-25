package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeServlet extends HttpServlet {
    public ThreeServlet() {
        System.out.println("开始创建ThreeServlet 对象");
    }

    //获取响应体
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "Hello";
        //通过响应对象,向tomcat索要输出流
        PrintWriter out = resp.getWriter();
        //通过输出流,将执行结果以二进制形式写入响应体
        out.write(result);
        System.out.println("ThreeServelet类针对浏览器发动Get方法处理");
    }//doGet 执行完毕
        //tomcat将响应包推送给浏览器
}

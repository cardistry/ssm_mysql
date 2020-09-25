package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "http://www.baidu.com";
        response.sendRedirect(address);

    }//tomcat 推送响应包之前看见响应体为空，但响应头location放了一个地址
        //此时，tomcat 将302 状态码写入状态行
    //在浏览器收到响应包之后，因为302状态码，浏览器不会读取响应体的内容，自动根据响应头
    //中的location 的地址发起第二次请求
}

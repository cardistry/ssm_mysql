package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//设置响应头中的location 对象
public class SixServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        将result 的值赋给响应头中的location 属性
//        response.sendRedirect(请求地址,请求方式,请求参数)
        response.sendRedirect("http://www.baidu.com?userName=mike");
    }
    /*浏览器在接收到响应包之后,如果发现响应头中存在
    location 的属性,就会通过地址栏向location指定网站发送请求*/
}

package com.bjpowennode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,money;
//      调用请求头，获得参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");
        //开卡
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);
        //发卡，将cookie 写入响应头交给浏览器
        response.addCookie(card1);
        response.addCookie(card2);
        //通知浏览器将订餐页面写入响应体中交给浏览器，跳转到点餐页面(请求转发)
        request.getRequestDispatcher("/index_2.html").forward(request,response);

    }
}

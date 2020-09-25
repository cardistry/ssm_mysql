package com.bjpowernnode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;
        //调用请求对象，请求请求头参数，得到用户选择的商品名
        goodsName = request.getParameter("goodsName");
        //调用请求对象，向tomcat 索要当前用户的私人储物柜
        HttpSession session = request.getSession();
        //查询私人储物柜中是否有用户选择的商品,并添加
        Integer nums = (Integer)session.getAttribute(goodsName);
        if(nums == null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,nums + 1);
        }

    }
}

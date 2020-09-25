package com.bjpowernnode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用请求对象，向tomcat 查询当前用户在服务端的私人物品
        HttpSession session = request.getSession();
        //将session中所有的key 取出来
        Enumeration goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()){
            String goodsName = (String) goodsNames.nextElement();
            int goodsNum = (int)session.getAttribute(goodsName);
            System.out.println("商品名称" + goodsName +" 商品数量" + goodsNum);

        }
    }
}

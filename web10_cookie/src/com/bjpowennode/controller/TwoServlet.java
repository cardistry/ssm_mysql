package com.bjpowennode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int priceDumplings = 30;
        int priceNoodlees = 20;
        int priceRice = 15;
        int money = 0;
        int consume = 0;
        int balance = 0;
        Cookie newCard = null;
        String food,userName = null;

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookiesArray = null;
        //根据请求头获取食物类型
        food = request.getParameter("food");
        //获取请求头中的cookie
        cookiesArray = request.getCookies();
        //刷卡消费
        for(Cookie cookie:cookiesArray){
            String key = cookie.getName();
            String value = cookie.getValue();
            if("userName".equals(key)){
                userName = value;
            }else if("money".equals(key)){
                money = Integer.parseInt(value);
                if("饺子".equals(food)) {
                    if (priceDumplings > money) {
                        out.print("用户 " + userName + " 余额不足，请充值");
                    }else {
                        newCard = new Cookie("money", (money - priceDumplings) + "");
                        consume = priceDumplings;
                    }
                }else if("面条".equals(food)){
                    if(priceNoodlees > money) {
                        out.print("用户 " + userName + " 余额不足，请充值");
                    }else{
                        newCard = new Cookie("money", (money - priceNoodlees) + "");
                        consume = priceNoodlees;
                    }

                }else if("盖饭".equals(food)){
                    if(priceRice > money) {
                        out.print("用户 " + userName + " 余额不足，请充值");
                    }else{
                        newCard = new Cookie("money", (money - priceRice) + "");
                        consume = priceRice;
                    }

                }
                balance = money - consume;
            }

        }
        response.addCookie(newCard);
        out.print("用户 "+userName +"本次消费 "+ consume + "余额 ："+balance );

    }
}

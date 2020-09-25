package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//设置context-type 的值
public class FiveServlet extends HttpServlet {
   /* 浏览器在接收到"Java<br/>Mysql<br/>Html<br/>"时
    没有将<br/>作为html 换行命令,而是当作文字栈时

    问题原因:浏览器在接收到响应包时,根据响应头中的content-type属性
    的值,因为"Java<br/>Mysql<br/>Html<br/>"对应类型为text,此时会用文本
    编辑器解析

    解决方法:提前设置contentType为text/html*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "Java<br/>Mysql<br/>Html<br/>";
        String result1 = "红烧肉<br/>梅菜扣肉<br/>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.println(result1);

    }
}

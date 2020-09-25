package com.bjpowernode.contronller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用请求对象对请求体使用utf-8重新编码
        String userName,password;

        UserDao dao = new UserDao();
        request.setCharacterEncoding("utf-8");
        //调用请求对象获得参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        //调用dao将验证信息推送到数据库服务器上
        int result = dao.login(userName,password);
        //调用响应对象，根据验证结果，将不同的结果写入响应头交给浏览器
        if(result == 1){
            //在判定来访用户身份合法后，通过请求对象线向tomcat申请一个HttpSession
            HttpSession session = request.getSession();
            response.sendRedirect("/MyWeb/index.html");
        }else{
            response.sendRedirect("/MyWeb/logi n_error.html");
        }
    }
}

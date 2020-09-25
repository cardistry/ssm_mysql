package com.bjpowernode.contronller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象,获得请求头等信息,获得用户的信息
        int result = 0;
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        Users user = null;
        PrintWriter out = null;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //2.调用UserDao将用户信息填充到INSERT命令,并借助jdbc发送到数据库
        user = new Users(null,userName,password,sex,email);
        result = dao.add(user);
        response.setContentType("text/html");
        out = response.getWriter();
        if(result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }

        //3.调用响应对象将处理结果以二进制的形式写入响应体中
    }
}
    //Tomcat负责销毁请求对象和响应对象
    //tomcat负责将http相应协议包推送到发起请求的浏览器上
    //浏览器根据响应头content-type指定编译器对应的二进制内容编译
    //浏览器将编译后的内容展示给用户
package com.bjpowernode.contronller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取请求头的参数（用户编号）
        String userId;
        UserDao dao = new UserDao();
        int result = 0;
        PrintWriter out = null;
        userId = request.getParameter("userId");
        //将detete 通过dao 发送到数据库
        result = dao.delete(userId);
        //调用响应对象将处理结果以二进制写回到响应体，交给浏览器
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result ==1){
            out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>用户信息删除失败</font>");
        }

    }
}

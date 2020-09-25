package com.bjpowernode.fliter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Onefliter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //通过拦截请求对象得到请求包参数信息，从而得到来访用户的真实年龄
        String age = servletRequest.getParameter("age");
        if(Integer.valueOf(age) < 70){  //合法请求
            //将拦截请求对象和响应对象交还给tomcat,由tomcat继续调用资源文件
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("<center><font style='color:red;font-size:40px'>大爷，珍爱生命啊!</font></center>");
        }
    }
}

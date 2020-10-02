package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器拦截用户请求
public class MyIntercepter implements HandlerInterceptor {
    private long btime = 0;

//    验证用户的登录信息
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器的preHandle方法");
        String loginName = "";
        Object attr = request.getSession().getAttribute("name");
        if(attr != null){
            loginName = (String)attr;
        }
        //判断登录名是否符合要求
        if(!"张三".equals(loginName)){
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        return true;
    }

}

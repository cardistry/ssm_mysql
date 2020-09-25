package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Onefilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //拦截后,通过请求对象向tomcat索要当前用户的HttpSession
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if(uri.indexOf("login") != -1 || "/MyWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpSession session = request.getSession(false);
            if(session != null) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);

        }
    }
}

package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器拦截用户请求
public class MyIntercepter implements HandlerInterceptor {
    private long btime = 0;
//    预处理方法
  /*  Object handler:被拦截的控制器对象
    特点：方法在控制器方法之前执行
    可以获取请求信息，验证是否符合要求，不满足要求可以拦截，满足可以放行，控制器方法可以执行*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("拦截器的MyIntercepterpreHandle方法");
       request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    /*ModelAndView 处理器方法的返回值
    * 可以影响最后执行结果，进行二次修正*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            modelAndView.addObject("mydate" ,new Date());
            modelAndView.setViewName("other");
        }
        System.out.println("拦截器的MyIntercepterpostHandle方法");
    }
    /*最后执行的方法
    Object handler:被拦截的处理器对象
    Exception ex:程序中发生的异常
    在请求处理后执行的，框架中规定对视图处理完成后，对视图进行了forward，视为请求处理完成
    一般用作资源回收，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("拦截器的MyIntercepterafterCompletion方法");
        long etime = System.currentTimeMillis();
        System.out.println("计算从prehandler 到请求完成时间时" + (etime - btime)+"ms");
    }
}

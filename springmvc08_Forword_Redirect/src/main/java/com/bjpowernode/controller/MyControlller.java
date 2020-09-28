package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller
public class MyControlller extends HttpServlet {

    /*处理器方法返回ModelAndView ，实现forword 操作
            语法：setViewName("forword:视图文件完整路径")
            forword 特点:不和视图解析器一同使用，就当项目中没有视图解析器
    */

    @RequestMapping(value = "/doForword.do")
    public ModelAndView doSome(){

        ModelAndView mv  = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");
//        显式转发，用于不在视图解析器内的静态资源访问
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }


    /**
     * 处理器方法返回ModelAndView,实现重定向redirect
     * 语法：setViewName("redirect:视图完整路径")
     * redirect特点： 不和视图解析器一同使用，就当项目中没有视图解析器
     *
     * 框架对重定向的操作：
     * 1.框架会把Model中的简单类型的数据，转为string使用，作为hello.jsp的get请求参数使用。
     *   目的是在 doRedirect.do 和 hello.jsp 两次请求之间传递数据
     *
     * 2.在目标hello.jsp页面可以使用参数集合对象 ${param}获取请求参数值
     *    ${param.myname}
     *
     * 3.重定向不能访问/WEB-INF资源
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doOther(String name,Integer age){

        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }


}
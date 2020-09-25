package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
@Controller
public class MyControlller extends HttpServlet {
   /*处理用户提交的请求，springmvc中是使用方法来处理的
    方法是自定义的，可以有多种返回值，多种参数，方法名称自定义*/

    /*准备使用doSome方法处理some.do请求
    @RequestMapping :请求映射，作用是把一个请求地址和一个方法绑定在一起。
                     一个请求指定一个方法来处理
            属性 ： 1.value 是一个String ，表示请求的uri地址的(some.do).
                    value的值必须是唯一的，不能重复，在使用时，推荐地址以"/"
            位置：1.在方法的上面
                 2.在类的上面
            说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法。
            使用@ RequestMapping修饰的方法可以处理请求的，类似Servlet中的doget,doPost.

            返回值：ModleandView 表示本次请求的处理结果
                Model : 数据,表示处理完成后，要显示给用户的数据
                View  : 视图,比如jsp等。
                     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
//        处理some.do 请求
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到requst的作用域。
        //request.setAttribute("msg","欢迎使用springmvc做web开发");
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forword操作，request.getRequestDispather("/show.jsp").forword();
        //mv.setViewName("/WEB-INF/view/show.jsp");
//        框架使用视图解析器的前缀+逻辑名称+后缀 组成完整路径，这里就是字符串连接操作
        mv.setViewName("show");
        return mv;
    }
}

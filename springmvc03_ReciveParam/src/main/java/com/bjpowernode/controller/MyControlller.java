package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller

public class MyControlller extends HttpServlet {
    /*
    逐个接受请求参数：
        要求：处理器（控制器）方法的形参名和请求中的参数名必须
        一致，同名的请求参数赋给同名的形参
    框架接受请求参数
        1.使用request对象接受请求参数
             String strName = request.getparameter("name");
             String strAge = request.getparameter("age");
        2. springmvc 框架通过DispatchServlet 调用MyController的doSome()
        方法时，按照名称对应，把接收的数据赋值给形参
        doSome(strName,Integer.valueOf(strAge))
        框架会提供自动类型转换的功能，能把String 转换成int,long,float,double 等类型。
    *
    */


    @RequestMapping(value = "/receiveproperty.do",method = RequestMethod.POST)
    public ModelAndView doSome(String myname,int myage){  // doGet()--service请求处理
        //处理some.do请求了。 相当于service调用处理完成了。
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname",myname);
        mv.addObject("myage",myage);
        mv.setViewName("show");
        return mv;
    }

  /*  请求中参数名和形参名不一样时
    @RequestParam:解决请求中参数名和形参名不一样
        属性：1.value 请求中的参数名称
             2.required ：true（默认） 请求中表示必须有这个参数
        位置：在处理方法的形参定义的前面
        只能用于逐个接收
   */

    @RequestMapping(value = "/receiveparam.do",method = RequestMethod.GET)
    public ModelAndView doParam(@RequestParam(value = "rname",required = false) String myname,@RequestParam(value = "rage",required = false) Integer myage){  // doGet()--service请求处理
        //处理some.do请求了。 相当于service调用处理完成了。
        System.out.println("name = " + myname + "myage = " + myage);
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname",myname);
        mv.addObject("myage",myage);
        mv.setViewName("show");
        return mv;
    }

    /*处理器形参是java对象，这个对象的属性名和请求中的参数名时一样的
    框架会创建java对象，给属性赋值，请求中参数时name,框架会调用setName()*/

    @RequestMapping(value = "/receiveobject.do",method = RequestMethod.POST)
    public ModelAndView doObject(Student student){  // doGet()--service请求处理
        System.out.println("doReturnView, name = " + student.getName() + "age = "+student.getAge());
        //处理some.do请求了。 相当于service调用处理完成了。
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.addObject("mystudent",student);
        mv.setViewName("show");
        return mv;
    }

}

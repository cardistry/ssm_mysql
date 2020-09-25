package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller

public class MyControlller extends HttpServlet {

    /*
    * 处理器方法返回String-- 表示逻辑视图名称，需要配置视图解析器

    * */
    @RequestMapping(value = "returnString-view",method = RequestMethod.POST)
    public String doReturnView(HttpServletRequest request, Student student){  // doGet()--service请求处理
        System.out.println("doReturnView, name = " + student.getName() + "age = "+student.getAge());
        request.setAttribute("myname",student.getName());
        request.setAttribute("myage",student.getAge());
        //show 逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forword转发操作
        return "show";
    }

}

package com.bjpowernode.controller;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller
public class MyControlller extends HttpServlet {


    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {

        ModelAndView mv  = new ModelAndView();

        if(!"lisi".equals(name)){
            throw new NameException("姓名不正确！！！");
        }
        if(age == null || age > 80){
            throw new AgeException("年龄太大了");
        }


        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        return mv;
    }


}
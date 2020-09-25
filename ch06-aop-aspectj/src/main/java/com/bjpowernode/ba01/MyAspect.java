package com.bjpowernode.ba01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

//@Aspect 表示当前类时切面类，
//切面类：给目标类增加功能，在这个类中有切面的功能代码
@Aspect
public class MyAspect {


    //定义方法，实现切面功能
    //方法要求：
    //public ,void 参数不是自定义的，有几个参数类型可以使用
    //参数1 JoinPoint 表示被代理的目标方法,如果使用必须是第一个位置
//    @Before(value = "execution(void *..SomeServiceImpl.do*(..))")
//    public void myBefore(JoinPoint jp){
//        System.out.println("方法的签名" + jp.getSignature());
//        System.out.println("方法的名称" + jp.getSignature().getName());
//        System.out.println("**** 前置通知： 切面功能：在目标执行之前输出时间" + new Date());
//
//    }


//    @AfterReturning :后置通知
//    属性：1. Value 切入点表达式
//            2.returning 自定义的变量，表示目标方法的返回值的
//                3.自定义的变量名和通知的方法名一样
//    优点：
//    能获得方法的返回值并且可以修改


//    @AfterReturning(value = "execution(String *..SomeServiceImpl.*(..))",
//                    returning = "res")
//    public void MyAfterReturning(Object res){
//        System.out.println("后置通知：在目标方法之后执行的");
//    }

    //环绕通知
//    1.public
//    2.必须有返回值，推荐使用object
//    3有参数，固定参数：
//@Around 属性：value 切入点表达式
//        在方法前后添加内容
//    返回值:目标方法的执行结果
    @Around(value = "execution(* *..SomeServiceImpl2.*(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
        Object res = null;
        System.out.println("环境感知：在目标方法之前输出" + new Date());
        res = pjp.proceed();
        System.out.println("环境感知：在目标方法之后提交事务" + new Date());
        return res;
    }
}

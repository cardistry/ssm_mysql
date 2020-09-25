package com.bjpowernode.ba01;

import org.springframework.stereotype.Component;

//value 就是实例化的对象的名称，等同于xml 中bean 的id 值
//value 值是唯一的，创建的对象在整个spring 容器中就一个
//位置：在类的上面
//@Component(value = "myStudent")
//省略value
//@Component("myStudent")
//不提供名称,使用spring 默认的
@Component //默认名是类名的首字母小写
//和 @Component 功能一致的注解还有
//@Repository (用于持久层):放在dao的实现类上,表示创建dao对象,dao对象是能够访问数据库的
//@Service (用于业务层的) 放在service 的实现类上,创建service 对象,service 对象是作业务处理,可以有事务等功能的.
//@Controller(用以控制层的上面) 放在控制器(处理器)类的上面,创建控制器对象,能够接受用户提供的参数,显示请求的处理结果
//以上三个用法和@Component是一样的,都能创建对象,但还有额外的功能
//@Repository @Service @Controller 是给对象分层的
//当类不是以上三种就使用@Component

public class Student {
    //@Value() 用于给简单属性赋值
//    1.用于属性定义之上
//    2.用于属性的set 方法之上

    public String name;

    public  Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

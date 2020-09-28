package com.bjpowernode.exception;
//当用户姓名异常时抛出
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}

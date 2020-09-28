package com.bjpowernode.exception;
//年龄异常时抛出
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}

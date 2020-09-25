package com.bjpowernode.exception;

public class NorEnoughException extends RuntimeException {
    public NorEnoughException(){
        super();
    }
    public NorEnoughException(String message){
        super(message);
    }
}

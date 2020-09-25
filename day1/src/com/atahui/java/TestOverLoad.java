package com.atahui.java;

import javax.print.DocFlavor;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class TestOverLoad {
    public static void main(String[] args) {
        Father f = new Father();
        Father son = new Son();
        //son.eat("来三碗米");
    }

}


class Father {
    Father(){
        System.out.println("I am father");
    }
    public void eat(){
        System.out.println("来两碗米");
    }
}

class Son extends Father {
    Son() {
        super();
        System.out.println("I am son");
    }

    public void eat(String s) {
        System.out.println(s);
    }
}




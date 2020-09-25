package com.atahui.java;
import java.io.File;
public class CreateDIr {
    public static void main(String[] args) {
        String str = "E:\\testjava\\testjava";
        File f = new File(str);
        f.mkdirs();
        System.out.println("中文");
    }
}

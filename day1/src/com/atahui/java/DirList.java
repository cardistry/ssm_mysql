package com.atahui.java;
import java.io.File;
public class DirList {
    public static void main(String[] args) {
        String path = "E:/";
        File dir = new File(path);
        if(dir.isDirectory()) {
            System.out.println("目录" + path);
            for (String str:dir.list()) {
                File newFile = new File(path + "/"+ str);
                if(newFile.isDirectory())
                    System.out.println(str + "是一个目录");
                else
                    System.out.println(str + "不是一个目录");
            }
        }
        else
            System.out.println(dir + "不是一个目录");
    }
}

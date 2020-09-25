package com.bjpowernode.ba03;

import org.springframework.beans.factory.annotation.Value;

//@Component("mySchool")
public class School {
    @Value("北京大学")
    public String name;
    @Value("北京")
    public String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

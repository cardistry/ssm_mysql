package com.bjpowernode.entity;

public class Users {
    private Integer Id;
    private String userName;
    private String passWord;
    private String sex;
    private String email;

    public Integer getId() {
        return Id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Users() {
    }

    public Users(Integer id, String userName, String passWord, String sex, String email) {
        Id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.email = email;
    }
}

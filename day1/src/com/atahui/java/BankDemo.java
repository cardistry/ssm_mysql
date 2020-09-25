package com.atahui.java;

import java.sql.DataTruncation;

public class BankDemo {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(70);
        System.out.println("ID is" + account.getID());
        account.deposit(1000);
        System.out.println("存款1000");
        try{
            account.withdraw(800);
            System.out.println("取走800");
            System.out.println("余额" + account.getAmount());
            account.withdraw(300);
            System.out.println("取走300");

        } catch (InsufficientFundsException e) {
            System.out.println("Sorry ,you are short" + account.getAmount());
            e.printStackTrace();
        }

    }
}

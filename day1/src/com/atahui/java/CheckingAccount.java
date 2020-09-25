package com.atahui.java;

public class CheckingAccount {
    private double amount;
    private int ID;
    public CheckingAccount (int ID){
        this.ID = ID;
    }
    public void deposit (double number){
        this.amount += number;
    }
    public void withdraw (double number) throws InsufficientFundsException{
        if(number <= amount)
            amount -= number;
        else{
            double needs = amount - number;
            System.out.println("余额不足");
            throw new InsufficientFundsException(needs);
        }
    }

    public double getAmount() {
        return amount;
    }

    public int getID() {
        return ID;
    }
}

package com.techelevator;

public class BankAccount { //yes we know I spelled it wrong

    private double balance = 10000;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void withdraw(double amountToWithdraw) {
        if (amountToWithdraw < balance) {
            balance -= amountToWithdraw;
        } else if( amountToWithdraw>balance){
            System.out.println("Not enough money in bank Account");
        }

    }

    public void deposit(double amountToDeposit) {
        balance += amountToDeposit;
    }
}

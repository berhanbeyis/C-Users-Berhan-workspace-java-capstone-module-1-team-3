package com.techelevator;

public class BankAccount { //yes we know I spelled it wrong

    private double balance = 100;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void withdraw(double amountToWithdraw) {
        balance -= amountToWithdraw;
    }

    public void deposit(double amountToDeposit) {
        balance += amountToDeposit;
    }
}

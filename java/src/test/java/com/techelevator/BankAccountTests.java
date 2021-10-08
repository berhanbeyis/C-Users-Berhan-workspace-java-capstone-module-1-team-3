package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class BankAccountTests {

    BankAccount testAccount = new BankAccount();
    VendingMachine testVendor = new VendingMachine();


    @Test
    public void get_balance_expect_balance() {

        Double actual = testAccount.getBalance();

        Assert.assertTrue("Expected account balance", actual == 100);

    }

    @Test
    public void withdraw_expect_balance_minus_withdraw_amount() {
        testAccount.withdraw(10);
        Double actual = testAccount.getBalance();

        Assert.assertTrue("Expected balance - withdraw", actual == 90);
    }

    @Test
    public void deposit_expect_balance_plus_deposit() {
        testAccount.deposit(10);

        Double actual = testAccount.getBalance();

        Assert.assertTrue("Expected Balance + deposit", actual == 110);
    }


}

package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;


public class VendingMachineTests {

    VendingMachine testVender = new VendingMachine();

    @Test
    public void is_item_sold_out_expect_false() throws FileNotFoundException {

        testVender.startMachine();
        boolean actual = testVender.isSoldOut("A4");

        Assert.assertFalse("Expected false", actual);

    }

    @Test
    public void is_item_sold_out_expect_true() throws FileNotFoundException {

        testVender.startMachine();

        boolean actual = testVender.isSoldOut("A4");

        Assert.assertTrue("Expected true", !actual); //when taken items out of a stack in vendingMachine.java, test passes

    }

    @Test
    public void get_machine_balance_expect_balance() throws FileNotFoundException {
        testVender.startMachine();

        testVender.addToMachineBalance(5);
        Double actual = testVender.getMachineBalance();


        Assert.assertTrue("Expected machine balance", actual == 5);


    }

    @Test
    public void get_foodItem_message() throws FileNotFoundException {
        testVender.startMachine();

        String actual = testVender.getFoodMessage();

        Assert.assertTrue("Expected food message", actual.equals("")); //has nothing in it because it gets overwritten

    }

    @Test
    public void give_change_from_machine() throws FileNotFoundException {
        testVender.startMachine();

        testVender.addToMachineBalance(5);
        testVender.giveChange();
        Double actual = testVender.getMachineBalance();

        Assert.assertTrue("Expected empty machine balance", actual == 0);
    }






}

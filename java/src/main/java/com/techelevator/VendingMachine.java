package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {

    private Map<String, Stack> products;



    private double vendingBalance;


    public VendingMachine (Map<String, Stack> products) {
        this.products = products;
    }

    public Map<String, Stack> getProducts() {
        return products;
    }

    public double getVendingBalance() {
        return vendingBalance;
    }

    public void startMachine () throws FileNotFoundException {
    }


}



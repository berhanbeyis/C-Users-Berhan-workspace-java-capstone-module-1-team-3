package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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

    public void startMachine() throws FileNotFoundException {
        File productList = new File("vendingmachine.csv");
        Scanner fileScanner = new Scanner(productList);

        Map<String, Stack> newMap = new HashMap<>();

        while (fileScanner.hasNext()) {
            String[] arr = new String[4];
            arr = fileScanner.nextLine().split("[|]");
            if (arr[3].equals("Chip")) {
                Chips chip = new Chips(arr[1], Double.parseDouble(arr[2]));
                Stack<Chips> chipsStack = new Stack<>();
                for (int i = 0; i <= 5; i++) {
                    chipsStack.push(chip);
                }
                newMap.put(arr[0], chipsStack);

            }
            else if (arr[3].equals("Gum")) {
                Gum gum = new Gum(arr[1], Double.parseDouble(arr[2]));
                Stack<Gum> gumStack = new Stack<>();
                for (int i = 0; i <= 5; i++) {
                    gumStack.push(gum);
                }
                newMap.put(arr[0], gumStack);

            } else if (arr[3].equals("Drink")) {
                Drink drink = new Drink(arr[1], Double.parseDouble(arr[2]));
                Stack<Drink> drinkStack = new Stack<>();
                for (int i = 0; i <= 5; i++) {
                    drinkStack.push(drink);
                }
                newMap.put(arr[0], drinkStack);

            } else {
                Candy candy = new Candy(arr[1], Double.parseDouble(arr[2]));
                Stack<Candy> candyStack = new Stack<>();
                for (int i = 0; i <= 5; i++) {
                    candyStack.push(candy);
                }
                newMap.put(arr[0], candyStack);
            }

        }

    }

}



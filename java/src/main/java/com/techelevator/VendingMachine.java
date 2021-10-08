package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine extends FoodItem {

    private Map<String, Stack> products;
    private double vendingBalance;
    private double machineBalance = 0;


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
                newMap.put(arr[0], chipsStack);  //(A1,{ Chips, chips chips chips chips })

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
            this.products = newMap;

        }

    }

    public  String displayItems() {

        for (Map.Entry<String,Stack> entry : products.entrySet()) {
            String key = entry.getKey();
            FoodItem firstItem = (FoodItem)entry.getValue().peek();
            System.out.println(key +" "+ firstItem.getName() +" "+ firstItem.getCost() );

        }return "";
    }

    public void chooseItem(String itemCode) {
        for(Map.Entry<String, Stack> entry : products.entrySet()) {
            String key = entry.getKey();
            FoodItem firstItem = (FoodItem)entry.getValue().peek();

            if(key.equals(itemCode)) {
                System.out.println(firstItem.getName()  + ", " + firstItem.getCost());
                System.out.println(firstItem.getFoodMessage());
                machineBalance -= firstItem.getCost();
            }
        }
    }

    public boolean isSoldOut(String itemCode) {
        for (Map.Entry<String, Stack> entry : products.entrySet()) {
            Stack stackName = entry.getValue();

            if (stackName.isEmpty()) {
                System.out.println("Item is sold out!");
                return true; //true for sold out
            }
        }
        return false; // not sold out
    }

    public void giveChange() {
        int countQuarters = 0;
        int countNickels = 0;
        int countDimes = 0;

        while(machineBalance >= 0.25) {
            machineBalance -= 0.25;
            countQuarters++;
        }
        while(machineBalance >= 0.10) {
            machineBalance -= 0.10;
            countDimes++;

        }
        while(machineBalance >= 0.05) {
            machineBalance -= 0.05;
            countNickels++;
        }
        System.out.println("Change: \nQuarters: " + countQuarters + "\nDimes: " + countDimes + "\nNickels: " + countNickels);
    }


    public Map<String, Stack> getProducts() {
        return products;
    }

    public double getVendingBalance() {
        return vendingBalance;
    }

    public double getMachineBalance() {
        return machineBalance;
    }

    public void addToMachineBalance(double amountToAdd) {
        machineBalance += amountToAdd;
    }



}



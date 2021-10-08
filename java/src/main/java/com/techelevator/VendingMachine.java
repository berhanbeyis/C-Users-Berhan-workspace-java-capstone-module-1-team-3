package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine extends FoodItem {

    private Map<String, Stack> products;
    private double vendingBalance;


//    public VendingMachine (Map<String, Stack> products) {
//        this.products = products;
//    }





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

//        Set<String> keys = products.keySet();

        for (Map.Entry<String,Stack> entry : products.entrySet()) {
            //FoodItem food = new FoodItem("blah", 2);
            //FoodItem food = entry.
            String key = entry.getKey();
            FoodItem firstItem = (FoodItem)entry.getValue().peek();
//            firstItem.getClass().getSimpleName();
            System.out.println(key +" "+ firstItem.getName() +" "+ firstItem.getCost() );


//
//            List<Stack> listOfStacks = new ArrayList<>();
//
//
//             for(int i = 0; i < products.size(); i++){
//                 listOfStacks.add(products.get(i));
//
//             }
//             for(int i = 0; i < listOfStacks.size(); i ++){
//                 listOfStacks.get(i).get
//             }
//


        }return "";
    }


    public Map<String, Stack> getProducts() {
        return products;
    }

    public double getVendingBalance() {
        return vendingBalance;
    }

}



package com.techelevator;

public class Drink extends FoodItem {



    public Drink (String name, double cost) {
        super(name, cost);
    }

    @Override
    public String getFoodMessage() {
        return "Glug Glug, Yum!";
    }

}

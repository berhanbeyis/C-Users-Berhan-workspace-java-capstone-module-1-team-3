package com.techelevator;

public class Chips extends FoodItem {

    public Chips (String name, double cost) {
        super(name, cost);
    }

    @Override
    public String getFoodMessage() {
        return "Crunch Crunch, Yum!";
    }
}

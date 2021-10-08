package com.techelevator;

public class Candy extends FoodItem {



    public Candy (String name, double cost) {
        super(name, cost);
    }

    @Override
    public String getFoodMessage() {
        return "Munch Munch, Yum!";
    }
}

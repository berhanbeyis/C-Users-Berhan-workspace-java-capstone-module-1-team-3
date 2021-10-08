package com.techelevator;

public class Gum extends FoodItem {


    public Gum(String name, double cost) {
        super(name, cost);
    }

    @Override
    public String getFoodMessage() {
        return "Chew Chew, Yum!";
    }
}

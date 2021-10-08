package com.techelevator;

public class Chip extends FoodItem {

    public Chip(String name, double cost) {
        super(name, cost);
    }

    @Override
    public String getFoodMessage() {
        return "Crunch Crunch, Yum!";
    }
}

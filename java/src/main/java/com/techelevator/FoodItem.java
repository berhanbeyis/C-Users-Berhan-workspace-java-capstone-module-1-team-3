package com.techelevator;

public class FoodItem {

    private String name;
    private double cost;

    public FoodItem (String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public FoodItem() {

    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}

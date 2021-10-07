package com.techelevator;

public class Gum extends FoodItem {

    private String message;

    public String getMessage() {
        return "Chew Chew, Yum!";
    }

    public Gum(String name, double cost) {
        super(name, cost);
    }
}

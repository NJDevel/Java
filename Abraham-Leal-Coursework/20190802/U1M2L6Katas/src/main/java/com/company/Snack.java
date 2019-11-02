package com.company;

public class Snack {

    protected int calories;
    protected int sugar;
    protected String Name;
    protected String producer;
    protected int sodium;
    protected String[] ingredients;
    protected int numOfServigns;
    protected float price;

    public Snack(){

    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumOfServigns() {
        return numOfServigns;
    }

    public void setNumOfServigns(int numOfServigns) {
        this.numOfServigns = numOfServigns;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

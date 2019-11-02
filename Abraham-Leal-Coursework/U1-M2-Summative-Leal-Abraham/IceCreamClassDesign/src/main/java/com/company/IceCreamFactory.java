package com.company;

import java.util.Map;

public class IceCreamFactory {

    //Descriptive attributes : unique identifier along with name(flavor) and description of flavor
    private int id;
    private String name;
    private String description;
    //Inventory can be measured in ounces : 16 oz pints, 32 oz quart, 128 oz gallon or larger for vats and commercial
    // sales
    private int amountInInventory;
    private float sellPrice;
    //Ingredient information/quantities
    private int sugar;
    private int milk;
    private int eggs;
    private int cream;
    private int butterfat;
    private String[] additives;
    private String[] flavorings;
    //Map to hold key(ingredient name) and the amount of each(Integer)
    private Map<String, Integer> recipe;


    public IceCreamFactory() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmountInInventory() {
        return amountInInventory;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public int getSugar() {
        return sugar;
    }

    public String[] getFlavorings() {
        return flavorings;
    }

    public int getMilk() {
        return milk;
    }

    public int getCream() {
        return cream;
    }

    public int getButterfat() {
        return butterfat;
    }

    public String[] getAdditives() {
        return additives;
    }

    public int getEggs() {
        return eggs;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmountInInventory(int amountInInventory) {
        this.amountInInventory = amountInInventory;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setFlavorings(String[] flavorings) {
        this.flavorings = flavorings;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCream(int cream) {
        this.cream = cream;
    }

    public void setButterfat(int butterfat) {
        this.butterfat = butterfat;
    }

    public void setAdditives(String[] additives) {
        this.additives = additives;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    public Map<String, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<String, Integer> recipe) {
        this.recipe = recipe;
    }

    public void decreaseInventory(int amountSold){
        this.amountInInventory = this.amountInInventory - amountSold;
    }
}

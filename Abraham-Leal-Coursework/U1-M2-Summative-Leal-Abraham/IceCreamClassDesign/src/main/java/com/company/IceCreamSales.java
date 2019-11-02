package com.company;

public class IceCreamSales {

    //Descriptive attributes : unique identifier along with name(flavor) and description of flavor
    private int id;
    private String name;
    private String description;
    //Inventory left followed by buy and sale prices
    //Inventory can be measured in ounces : 4 oz in a scoop, 16 oz pint, 32 oz quart, 128 oz gallon
    private int amountInInventory;
    private float buyPrice;
    private float sellPrice;
    //Nutritional information
    private int totalFat;
    private int totalCalories;

    public IceCreamSales() {
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

    public float getBuyPrice() {
        return buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmountInInventory(int amountInInventory) {
        this.amountInInventory = amountInInventory;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void decreaseInventory(int inventorySpent){
        this.amountInInventory = this.amountInInventory - inventorySpent ;
    }

    public float getSalePrice(int amountServed){
        float salePrice;
        salePrice = amountServed * this.sellPrice;
        return salePrice;
    }
}

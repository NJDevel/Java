package com.company;

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturerIn, String modelIn, int carafeSizeIn, int cupsLeftIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }

    public String getManufacturer () {
        return this.manufacturer;
    }

    public String getModel(){
        return this.model;
    }

    public int getCarafeSize(){
        return this.carafeSize;
    }

    public int getCupsLeft() {
        return this.cupsLeft;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public void brew(){
        this.powered = true;
    }

    public void pourCoffee(int numCups){
        this.cupsLeft = this.cupsLeft- numCups;
    }
}

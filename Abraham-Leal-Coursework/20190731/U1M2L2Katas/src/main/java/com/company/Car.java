package com.company;

public class Car {

    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    public Car(String makeIn, String modelIn, String typeIn, String colorIn, String engineIn, String transmissionIn,
               int numDoorsIn, double mpgIn, int milesDrivenIn) {
        this.make = makeIn;
        this.model = modelIn;
        this.type = typeIn;
        this.color = colorIn;
        this.engine = engineIn;
        this.transmission = transmissionIn;
        this.numDoors = numDoorsIn;
        this.mpg = mpgIn;
        this.milesDriven = milesDrivenIn;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public int getNumDoors() {
        return this.numDoors;
    }

    public double getMpg() {
        return this.mpg;
    }

    public int getMilesDriven() {
        return this.milesDriven;
    }

    public void drive(int miles){
        this.milesDriven = this.milesDriven + miles;
    }

    public void honk(){
        System.out.println("HONK");
    }
}

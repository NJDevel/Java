package com.company;

public class Engine {

    private int horsePower;
    private int liters;
    private int cylinders;

    public Engine(){

    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getLiters() {
        return liters;
    }

    public int getCylinders() {
        return cylinders;
    }
}

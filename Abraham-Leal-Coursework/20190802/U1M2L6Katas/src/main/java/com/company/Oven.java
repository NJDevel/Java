package com.company;

public class Oven {

    protected String model;
    protected String make;
    protected boolean isGasPowered;

    public Oven(){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isGasPowered() {
        return isGasPowered;
    }

    public void setGasPowered(boolean gasPowered) {
        isGasPowered = gasPowered;
    }
}

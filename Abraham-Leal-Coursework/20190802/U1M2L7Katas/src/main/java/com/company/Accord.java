package com.company;

public class Accord extends Sedan {

    protected String year;
    protected Engine engine;
    protected Transmission transmission;

    public Accord(){

    }

    public String getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}

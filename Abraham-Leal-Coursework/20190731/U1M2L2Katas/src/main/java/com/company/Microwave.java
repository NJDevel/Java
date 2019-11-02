package com.company;

public class Microwave {

    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturerIn, String modelIn, int secondsLeftIn, String timeIn, boolean runningIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftIn;
        this.time = timeIn;
        this.running = runningIn;
    }

    public void start(int secondsLeftIn) {
        this.secondsLeft = secondsLeftIn;
    }

    public void stop(){
        this.running = false;
    }

    public void clear() {
        this.secondsLeft = 0;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isRunning() {
        return this.running;
    }
}

package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int lastClickedLocation[];

    public ComputerMouse(String manufacturerIn, String modelIn, int xPositionIn, int yPositionIn, int[] lastClickedLocationIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.xPosition = xPositionIn;
        this.yPosition = yPositionIn;
        this.lastClickedLocation = lastClickedLocationIn;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getxPosition() {
        return this.xPosition;
    }
    public int getyPosition() {
        return this.yPosition;
    }

    public int[] getLastClickedLocation() {
        return this.lastClickedLocation;
    }

    public void move(int deltaX, int deltaY){
        this.xPosition = deltaX;
        this.yPosition = deltaY;
    }

    public void click(){
        this.lastClickedLocation = new int[]{this.xPosition,this.yPosition};
    }
}

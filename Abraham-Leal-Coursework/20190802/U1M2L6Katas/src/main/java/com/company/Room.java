package com.company;

public class Room {

    private float squareFootage;
    private float length;
    private float width;
    private String flooringType;
    private float height;
    private int numWindows;
    private int numElectricalOutlets;

    public Room() {

    }

    public float getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(float squareFootage) {
        this.squareFootage = squareFootage;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public int getNumElectricalOutlets() {
        return numElectricalOutlets;
    }

    public void setNumElectricalOutlets(int numElectricalOutlets) {
        this.numElectricalOutlets = numElectricalOutlets;
    }
}

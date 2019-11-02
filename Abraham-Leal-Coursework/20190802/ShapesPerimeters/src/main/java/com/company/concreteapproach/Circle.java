package com.company.concreteapproach;

public class Circle extends Shape{
    protected int radius;
    protected int diameter;

    public Circle(){

    }

    @Override
    public void area() {
        super.area();
    }

    @Override
    public void perimeter() {
        super.perimeter();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}

package com.company.concreteapproach;

public class Square extends Shape{

    protected int side;

    @Override
    public void area() {
        super.area();
    }

    @Override
    public void perimeter() {
        super.perimeter();
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

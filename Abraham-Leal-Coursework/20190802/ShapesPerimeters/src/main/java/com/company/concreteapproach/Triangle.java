package com.company.concreteapproach;

public class Triangle extends Shape {
    protected int a, b, c;
    protected int height;

    public Triangle(){

    }

    @Override
    public void area() {
        super.area();
    }

    @Override
    public void perimeter() {
        super.perimeter();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

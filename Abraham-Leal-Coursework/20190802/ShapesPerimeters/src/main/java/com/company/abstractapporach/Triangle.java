package com.company.abstractapporach;

import com.company.abstractapporach.Shape;

public class Triangle extends Shape {

    int a, b, c;
    int height;

    public Triangle(){

    }

    @Override
    public void perimeter() {

    }

    @Override
    public void area() {

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

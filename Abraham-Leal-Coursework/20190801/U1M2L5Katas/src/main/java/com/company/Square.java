package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {

    private int side;

    public Square(){

    }

    public double perimeter() {
        return this.side*4;
    }

    public double area(){
        return this.side * this.side;

    }
}

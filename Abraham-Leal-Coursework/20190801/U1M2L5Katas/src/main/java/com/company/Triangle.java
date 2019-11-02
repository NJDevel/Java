package com.company;

import com.company.interfaces.Shape;

public class Triangle implements Shape {

    private double a, b, c;
    private double heightFromBase;

    public Triangle(){

    }

    public double perimeter(){
        return a + b + c;
    }

    public double area(){
        return (heightFromBase*b)/2;
    }
}

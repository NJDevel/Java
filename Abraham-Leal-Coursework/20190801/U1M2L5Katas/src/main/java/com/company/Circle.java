package com.company;

import com.company.interfaces.Shape;

public class Circle implements Shape {

    private double diameter;
    private double radius;
    private double pi;

    public Circle(){

    }

    public double perimeter(){
        return 2*diameter*radius*pi;
    }

    public double area(){
        return pi * (radius*radius);
    }


}

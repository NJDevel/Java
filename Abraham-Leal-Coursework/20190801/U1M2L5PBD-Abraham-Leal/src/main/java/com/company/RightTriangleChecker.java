package com.company;

import java.util.Scanner;

public class RightTriangleChecker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b, c;

        System.out.print("Enter three integers\nSide 1: ");
        a = Integer.parseInt(in.nextLine());
        System.out.print("Side 2: ");
        b = Integer.parseInt(in.nextLine());

        while (a > b){
            System.out.print("\n"+ b +" is smaller than "+ a +". Try again.\nSide 2: ");
            b = Integer.parseInt(in.nextLine());
        }
        System.out.print("Side 3: ");
        c = Integer.parseInt(in.nextLine());

        while (b > c){
            System.out.print("\n" + c +" is smaller than "+ b +". Try again.\nSide 3: ");
            c = Integer.parseInt(in.nextLine());
        }

        System.out.println("\nYour three sides are " + a +" "+ b + " " + c + "\n");

        if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        } else
            System.out.println("NO!  These sides do not make a right triangle!");
    }
}

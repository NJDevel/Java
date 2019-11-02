package com.company;
import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        float a, b, c;

        System.out.println("Please input three numbers: ");
        a = in.nextFloat();
        b = in.nextFloat();
        c = in.nextFloat();

        float product = (a * b * c);
        System.out.println("The product of the three numbers is: " + product);


    }
}
package com.company;

import java.util.Scanner;

public class EvenOrOdd {
//Asks user for a number and tells you whether it is even or odd
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Please enter a number:");
        num = in.nextInt();

        if((num%2)==0){
            System.out.println("The number " + num + " is an even number.");
        } else {
            System.out.println("The number " + num + " is an odd number.");
        }

    }
}

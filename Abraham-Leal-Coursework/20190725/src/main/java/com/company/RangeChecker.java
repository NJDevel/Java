package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;
        boolean inRange = false;

        System.out.println("Please enter a number between 15 and 32:");
        num = in.nextInt();

        while(inRange == false){
            if (num > 15 && num < 32){
            System.out.println("The number "+ num + " is a good entry!");
            inRange = true;
            } else {
            System.out.println("Bad entry! Please enter a number between 15 and 32:");
            num = in.nextInt();
            }

        }
    }
}


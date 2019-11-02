package com.company;

import java.util.Scanner;

public class CountByTwo {
//Asks user for a number and counts by two until that number is reached
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Please enter a number:");
        num = in.nextInt();

        for (int i = 0; i <= num; i= i + 2) {
            System.out.println(i);

        }
    }
}
package com.company;

import java.util.Scanner;

public class CountByThirteen {
//Asks user for a number and counts to it by increments of 13
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Please enter a number:");
        num = in.nextInt();

        for (int i = 0; i <= num; i= i + 13) {
            System.out.println(i);

        }

    }
}
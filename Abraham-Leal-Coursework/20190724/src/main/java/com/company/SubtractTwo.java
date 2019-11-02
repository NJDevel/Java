package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a;
        int b;

        System.out.println("Please input 2 numbers: ");

        a = Integer.parseInt(in.nextLine());
        b = Integer.parseInt(in.nextLine());

        int diff = a - b;

        System.out.println("Subtracting 2nd number for 1st is equal to :" + diff);


    }
}

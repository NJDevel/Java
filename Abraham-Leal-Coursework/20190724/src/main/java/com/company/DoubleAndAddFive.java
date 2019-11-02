package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a;

        System.out.println("Please input a number: ");

        a = Integer.parseInt(in.nextLine());

        int sum = a *2 + 5;

        System.out.println("Your number doubled and increased by 5 equals: " + sum);

    }
}

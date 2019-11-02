package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a;

        System.out.println("Please input a number: ");

        a = Integer.parseInt(in.nextLine());

        int sum = (a + 5)*2;

        System.out.println("5 added to your number than doubled equals: " + sum);

    }
}

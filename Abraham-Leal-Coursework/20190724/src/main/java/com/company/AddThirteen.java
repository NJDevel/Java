package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a;

        System.out.println("Please input a number: ");

        a = Integer.parseInt(in.nextLine());

        int sum = a + 13;

        System.out.println("13 added to your number equals: " + sum);

    }
}

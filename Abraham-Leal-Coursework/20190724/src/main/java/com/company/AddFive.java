package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String a, b, c, d, e;

        System.out.println("Please input 5 numbers: ");

        //a = Float.parseFloat(in.nextLine());

        a = in.nextLine();
        b = in.nextLine();
        c = in.nextLine();
        d = in.nextLine();
        e = in.nextLine();

        int sum = (Integer.parseInt(a)) + (Integer.parseInt(b)) + (Integer.parseInt(c)) + (Integer.parseInt(d)) + (Integer.parseInt(e));

        System.out.println("The sum of the five numbers is : " + sum);



    }
}

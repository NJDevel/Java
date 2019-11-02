package com.company;

import java.util.Scanner;

public class ValidNumber {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Prompts the user to enter a number between 1 and 10.
        System.out.println("Please enter a number between 1 and 10: ");
        int num = Integer.parseInt(in.nextLine());

        //If the user enters a number less than 1 or greater than 10, display the following error message & prompts
        //for another number
        while (num < 1 || num > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            num = Integer.parseInt(in.nextLine());
        }
        System.out.println(num);
    }
}

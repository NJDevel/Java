package com.company;

import java.util.Scanner;

public class MonthConverterIf {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Prompts the user to enter a number between 1 and 12.
        System.out.println("Please enter a number between 1 and 12: ");
        int month = in.nextInt();

        //Prints  error message if the user enters a number less than 1 or greater than 12
        if (month < 1 || month > 12) {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        } else {
            //Print out the name of the month corresponding to the number typed in by the user.
            if (month == 1) {
                System.out.println("January");
            } else if (month == 2) {
                System.out.println("February");
            } else if (month == 3) {
                System.out.println("March");
            } else if (month == 4) {
                System.out.println("April");
            } else if (month == 5) {
                System.out.println("May");
            } else if (month == 6) {
                System.out.println("June");
            } else if (month == 7) {
                System.out.println("July");
            } else if (month == 8) {
                System.out.println("August");
            } else if (month == 9) {
                System.out.println("September");
            } else if (month == 10) {
                System.out.println("October");
            } else if (month == 11) {
                System.out.println("November");
            } else if (month == 12) {
                System.out.println("December");
            }
        }


    }
}

package com.company;

import java.util.Scanner;

public class UltimateQuestion {
//Program will ask user to enter a number and will keep asking until user enters 42.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Please enter a number between 1 and 100: ");
        num = in.nextInt();

        while (num != 42){
            System.out.println("Please enter a number between 1 and 100: ");
            num = in.nextInt();
        }
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}

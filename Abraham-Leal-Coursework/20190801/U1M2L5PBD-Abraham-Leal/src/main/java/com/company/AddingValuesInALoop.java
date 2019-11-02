package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        int sum = 0;
        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number: " );
        input = Integer.parseInt(in.nextLine());
        sum = sum + input;

        while(input != 0){
            sum = sum + input;
            System.out.println("The total so far is: "+ sum);
            System.out.print("Number: ");
            input = Integer.parseInt(in.nextLine());
        }
        System.out.println("\nThe total is "+ sum);

    }
}

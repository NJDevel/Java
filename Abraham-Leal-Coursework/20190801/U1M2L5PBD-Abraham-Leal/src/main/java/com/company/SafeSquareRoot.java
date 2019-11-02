package com.company;

import java.util.Scanner;

public class SafeSquareRoot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;

        System.out.print("SQUARE ROOT!\nEnter a number: ");
        n = Integer.parseInt(in.nextLine());

        while (n < 0){
            System.out.print("You can't take the square root of a negative number, silly.\nTry again: ");
            n = Integer.parseInt(in.nextLine());
        }
        System.out.println("\nThe square root of "+ n + " is "+ Math.sqrt(n));
    }
}

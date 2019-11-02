package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random randomGenerator = new Random();
        int ranNumber = randomGenerator.nextInt(10) + 1;

        System.out.print("I'm thinking of a number between 1 - 10: ");
        int numGuess = Integer.parseInt(in.nextLine());

        if (numGuess < 1 || numGuess > 10) {
            System.out.println("Invalid entry");
            System.out.println("I'm thinking of a number between 1 - 10");
            numGuess = Integer.parseInt(in.nextLine());
        } else if (numGuess != ranNumber) {
            System.out.println("Your guess: " + numGuess +"\n");
            System.out.println("Sorry, but I was really thinking of " + ranNumber + ".");
        } else
            System.out.println("That's right! My secret number was " + ranNumber + "!");

    }


}

package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLoLimited {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random randomGenerator = new Random();
        int ranNumber = randomGenerator.nextInt(100) + 1;
        int counter = 0;

        System.out.print("I am thinking of a number between 1 - 100. Try to guess it. ");
        int numGuess = Integer.parseInt(in.nextLine());
        System.out.print("Your guess: " + numGuess + "\n");
        counter++;

        while (numGuess != ranNumber && counter != 7) {
            if (numGuess > ranNumber) {
                System.out.print("Sorry, you are too high.");
                numGuess = Integer.parseInt(in.nextLine());
                counter++;
                System.out.print("Guess #" + counter + ": " + numGuess + "\n");
            } else if (numGuess < ranNumber) {
                System.out.print("Sorry, you are too low.");
                numGuess = Integer.parseInt(in.nextLine());
                counter++;
                System.out.print("Guess #" + counter + ": " + numGuess + "\n");
            }
        }
        if (numGuess == ranNumber) {
            System.out.println("You guessed it! What are the odds?!?");
        } else {
            System.out.println("Sorry you didn't guess it in " + counter + " tries. You lose.");
        }
    }
}

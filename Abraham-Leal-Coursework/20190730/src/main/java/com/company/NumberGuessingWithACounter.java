package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random randomGenerator = new Random();
        int ranNumber = randomGenerator.nextInt(10) + 1;
        int counter = 0;

        System.out.print("I have chosen a number between 1 - 10. Try to guess it. ");
        int numGuess = Integer.parseInt(in.nextLine());
        System.out.print("Your guess: " + numGuess + "\n");
        counter++;

        while (numGuess != ranNumber){
            System.out.print("That is incorrect. Guess again. ");
            numGuess = Integer.parseInt(in.nextLine());
            counter++;
            System.out.print("Your guess: " + numGuess + "\n");
        }
        System.out.println("That's right! You're a good guesser!");
        System.out.println("It only took you " + counter + " tries. ");
    }
}

package com.company;

import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

public class LittleQuiz {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Are you ready for a little quiz? ");
        String ans1 = in.nextLine();

        int numRight = 0;
        int numWrong = 0;

        if (ans1.equalsIgnoreCase("n")|| ans1.equalsIgnoreCase("no")) {
            System.out.println("Have a nice day!");
        } else if(ans1.equalsIgnoreCase("y")||ans1.equalsIgnoreCase("yes")){
            System.out.println("Ok, here it comes!\n");

            //Write an interactive quiz. It should ask the user three multiple-choice or true/false questions about
            // something. It must keep track of how many they get wrong, and print out a "score" at the end.

            System.out.println("What is the capital of the United States? \n\t1. New York\n\t2. Philadelphia\n\t" +
                    "3. Washington DC");

            int ans = Integer.parseInt(in.nextLine());

            if (ans == 3) {
                System.out.println("Correct!\n");
                numRight = numRight + 1;
            } else {
                numWrong = numWrong + 1;
                System.out.println("Wrong! Washington D.C is the capital of the United States.\n");
            }

            System.out.println("Can you store the value 'cat' inside of a variable type int?\n\t1. Yes\n\t2. No");
            ans = Integer.parseInt(in.nextLine());

            if (ans == 2) {
                System.out.println("Correct!\n");
                numRight = numRight + 1;
            } else {
                numWrong = numWrong + 1;
                System.out.println("Sorry, cat is a string and ints can only hold numbers.\n");
            }

            System.out.println("What is the result of 9+6/3?\n\t1. 5\n\t2. 11 \n\t3. 15/3");
            ans = Integer.parseInt(in.nextLine());

            if (ans == 2) {
                System.out.println("Correct!\n");
                numRight = numRight + 1;
            } else {
                numWrong = numWrong + 1;
                System.out.println("Sorry, the correct answer is 11 because of the order of operations rules.\n");
            }
            System.out.println("Overall you got " + numRight + " out of 3 correct.\nThanks for playing!");

        } else {
            System.out.println("Invalid entry. Goodbye");
        }
    }
}

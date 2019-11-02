package com.company;

import java.util.Random;

public class ShorterDoubleDice {

    public static void main(String[] args) {

        Random randomGenerator = new Random();

        int rollValue1 = randomGenerator.nextInt(6) + 1;
        int rollValue2 = randomGenerator.nextInt(6) + 1;
        System.out.println("HERE COMES THE DICE!\n");

        do {
            System.out.println("Roll #1: " + rollValue1);
            System.out.println("Roll #2: " + rollValue2);
            System.out.println("The total is " + (rollValue1 + rollValue2) + "!\n");
            rollValue1 = randomGenerator.nextInt(6) + 1;
            rollValue2 = randomGenerator.nextInt(6) + 1;
        } while(rollValue1 != rollValue2);

    }
}

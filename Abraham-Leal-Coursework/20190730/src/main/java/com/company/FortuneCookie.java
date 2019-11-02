package com.company;

import java.util.Random;
import java.util.Scanner;

public class FortuneCookie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random randomGenerator = new Random();
        int ranNumber = randomGenerator.nextInt(6) + 1;
        int l1 = randomGenerator.nextInt(53) + 1;
        int l2 = randomGenerator.nextInt(53) + 1;
        int l3 = randomGenerator.nextInt(53) + 1;
        int l4 = randomGenerator.nextInt(53) + 1;
        int l5 = randomGenerator.nextInt(53) + 1;
        int l6 = randomGenerator.nextInt(53) + 1;

        if (ranNumber == 1) {
            System.out.println("A dubious friend may be an enemy in camouflage.");

        } else if (ranNumber == 2) {
            System.out.println("A faithful friend is a strong defense.");

        } else if (ranNumber == 3) {
            System.out.println("A golden egg of opportunity falls into your lap this month.");

        } else if (ranNumber == 4) {
            System.out.println("A light heart carries you through all the hard times.");

        } else if (ranNumber == 5) {
            System.out.println("A truly rich life contains love and art in abundance.");

        } else if (ranNumber == 6) {
            System.out.println("Curiosity kills boredom. Nothing can kill curiosity.");

        }
        System.out.println("\t" + l1 + " - " + l2 + " - " + l3 + " - " + l4 + " - " +
                l5 + " - " + l6);
    }
}







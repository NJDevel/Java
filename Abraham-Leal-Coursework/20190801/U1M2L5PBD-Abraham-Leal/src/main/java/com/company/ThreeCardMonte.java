package com.company;
import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner in = new Scanner(System.in);
        int ball;
        int guess;
        ball = randomGenerator.nextInt(3) +1;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n\n" +
                "Which one is the ace?\n\n" +
                "\t\t##\t##\t##\n" +
                "\t\t##\t##\t##\n" +
                "\t\t1\t2\t3");

        guess = Integer.parseInt(in.nextLine());

        if (guess == ball){

            switch (ball){
                case 1:
                    System.out.println("\t\tAA\t##\t##\n" +
                                        "\t\tAA\t##\t##\n" +
                                        "\t\t1\t2\t3\n");
                    break;
                case 2:
                    System.out.println("\t\t##\tAA\t##\n" +
                            "\t\t##\tAA\t##\n" +
                            "\t\t1\t2\t3\n");
                    break;
                case 3:
                    System.out.println("\t\t##\t##\tAA\n" +
                            "\t\t##\t##\tAA\n" +
                            "\t\t1\t2\t3\n");
                    break;
            }

            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        } else {

            switch (ball) {
                case 1:
                    System.out.println("\t\tAA\t##\t##\n" +
                            "\t\tAA\t##\t##\n" +
                            "\t\t1\t2\t3\n");
                    break;
                case 2:
                    System.out.println("\t\t##\tAA\t##\n" +
                            "\t\t##\tAA\t##\n" +
                            "\t\t1\t2\t3\n");
                    break;
                case 3:
                    System.out.println("\t\t##\t##\tAA\n" +
                            "\t\t##\t##\tAA\n" +
                            "\t\t1\t2\t3\n");
                    break;
            }
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + ball + ".");
        }


    }


}

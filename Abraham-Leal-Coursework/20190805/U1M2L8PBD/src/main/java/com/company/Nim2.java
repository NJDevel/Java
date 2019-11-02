package com.company;

import java.util.Scanner;

public class Nim2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int PileA, PileB, PileC;
        String player1, player2, currentPlayer;
        PileA = 3;
        PileB = 3;
        PileC = 3;
        String choice = "";
        int remove;
        boolean go = true;
        boolean validChoice = false;
        boolean not0 = false;
        boolean validPile = false;

        System.out.print("Player1 enter your name: ");
        player1 = in.nextLine();
        System.out.print("Player2 enter your name: ");
        player2 = in.nextLine();
        currentPlayer = player1;


        while (go != false) {
            if (currentPlayer.equals(player1)) {
                System.out.print("A: " + PileA + "\tB: " + PileB + "\tC: " + PileC + "\n\n" +
                        player1 + " choose a pile: ");
                choice = in.nextLine();

            } else if (currentPlayer.equals(player2)) {
                System.out.print("A: " + PileA + "\tB: " + PileB + "\tC: " + PileC + "\n\n" +
                        player2 + " choose a pile: ");
                choice = in.nextLine();

            }

            while (validChoice == false) {
                if (choice.equalsIgnoreCase("a")) {
                    if (PileA <= 0) {
                        System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                        choice = in.nextLine();
                    } else {
                        System.out.print("How many to remove from pile " + choice + ": ");
                        remove = Integer.parseInt(in.nextLine());
                        while (not0 == false) {
                            if (remove > PileA) {
                                System.out.print("Pile A doesn't have that many. Try again: ");
                                remove = Integer.parseInt(in.nextLine());
                            } else if (remove <= 0) {
                                System.out.print("You must choose at least 1. How many?");
                                remove = Integer.parseInt(in.nextLine());
                            } else {
                                not0 = true;
                            }
                        }
                        PileA = PileA - remove;
                        validChoice = true;
                        not0 = false;
                    }
                }
                if (choice.equalsIgnoreCase("b")) {
                    if (PileB <= 0) {
                        System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                        choice = in.nextLine();
                    } else {
                        System.out.print("How many to remove from pile " + choice + ": ");
                        remove = Integer.parseInt(in.nextLine());
                        while (not0 == false) {
                            if (remove > PileB) {
                                System.out.print("Pile B doesn't have that many. Try again: ");
                                remove = Integer.parseInt(in.nextLine());
                            } else if (remove <= 0) {
                                System.out.print("You must choose at least 1. How many?");
                                remove = Integer.parseInt(in.nextLine());
                            } else {
                                not0 = true;
                            }
                        }
                        PileB = PileB - remove;
                        validChoice = true;
                        not0 = false;
                    }

                }
                if (choice.equalsIgnoreCase("c")) {
                    if (PileC <= 0) {
                        System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                        choice = in.nextLine();
                    } else {
                        System.out.print("How many to remove from pile " + choice + ": ");
                        remove = Integer.parseInt(in.nextLine());
                        while (not0 == false) {
                            if (remove > PileC) {
                                System.out.print("Pile C doesn't have that many. Try again: ");
                                remove = Integer.parseInt(in.nextLine());
                            } else if (remove <= 0) {
                                System.out.print("You must choose at least 1. How many?");
                                remove = Integer.parseInt(in.nextLine());
                            } else {
                                not0 = true;
                            }
                        }
                        PileC = PileC - remove;
                        validChoice = true;
                        not0 = false;
                    }

                }
            }
            validChoice = false;

            if (currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else if (currentPlayer.equals(player2)) {
                currentPlayer = player1;
            }

            if ((PileA < 1) && (PileB < 1) && (PileC < 1)) {
                go = false;
            }
        }
        if (currentPlayer.equals(player2)) {
            System.out.println("\n" + player2 + ", there are no counters left, so you WIN!");
        } else
            System.out.println("\n" + player1 + ", there are no counters left, so you WIN!");

    }
}




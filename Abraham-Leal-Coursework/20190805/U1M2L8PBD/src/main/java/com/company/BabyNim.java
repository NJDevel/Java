package com.company;

import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int PileA, PileB, PileC;
        PileA = 3;
        PileB = 3;
        PileC = 3;
        String choice;
        int remove;
        boolean go = true;


        while( go != false || PileA > 0) {
            System.out.print("A: " + PileA + "\tB: " + PileB + "\tC: " + PileC + "\n\n" +
                    "Choose a pile: ");
            choice = in.nextLine();

            if (choice.equalsIgnoreCase("a")) {
                System.out.print("How many to remove from pile " + choice + ": ");
                remove = Integer.parseInt(in.nextLine());
                PileA = PileA - remove;
            }
            if (choice.equalsIgnoreCase("b")) {
                System.out.print("How many to remove from pile " + choice + ": ");
                remove = Integer.parseInt(in.nextLine());
                PileB = PileB - remove;
            }
            if (choice.equalsIgnoreCase("c")) {
                System.out.print("How many to remove from pile " + choice + ": ");
                remove = Integer.parseInt(in.nextLine());
                PileC = PileC - remove;
            }
            if (PileA < 1 && PileB < 1) {
                if (PileC < 1) {
                    go = false;
                }
            }
        }
        System.out.println("\nAll piles are empty. Good job!");
    }


}


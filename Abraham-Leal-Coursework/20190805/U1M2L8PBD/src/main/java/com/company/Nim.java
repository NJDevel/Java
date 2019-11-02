package com.company;

import java.util.Scanner;

public class Nim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int PileA, PileB, PileC;
        String player1, player2;
        PileA = 3;
        PileB = 3;
        PileC = 3;
        String choice = "";
        int remove;
        boolean go = true;
        boolean turn = true;

        System.out.print("Player1 enter your name: ");
        player1 = in.nextLine();
        System.out.print("Player2 enter your name: ");
        player2 = in.nextLine();



        while( go != false || PileA > 0) {
            if(turn == true){
                System.out.print("A: " + PileA + "\tB: " + PileB + "\tC: " + PileC + "\n\n" +
                        player1 +" choose a pile: ");
                choice = in.nextLine();
                turn = false;
            } else if(turn == false){
                System.out.print("A: " + PileA + "\tB: " + PileB + "\tC: " + PileC + "\n\n" +
                        player2 +" choose a pile: ");
                choice = in.nextLine();
                turn = true;
            }


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
        if(turn == false){
            System.out.println("\n"+ player2 + ", there are no counters left, so you WIN!");
        } else
            System.out.println("\n"+ player1 + ", there are no counters left, so you WIN!");

    }
}

package com.company;

import java.util.Random;

public class BabyBlackjack {

    public static void main(String[] args) {
        //Pick two values from 1-10 for the player. These are the player's "cards".
        //Pick two more values from 1-10 for the dealer.
        //Whoever has the highest total is the winner.
        //There is no betting, no busting, and no hitting. Save that for real blackjack.

        Random random = new Random();
        int player1 = random.nextInt(10) +1;
        int player2 = random.nextInt(10) +1;
        int playerSum = player1 + player2;

        int dealer1 = random.nextInt(10) +1;
        int dealer2 = random.nextInt(10) +1;
        int dealerSum = dealer1 + dealer2;

        System.out.println("Baby Blackjack!\n\n" +
                "You drew " + player1 + " and " + player2 +"\n" +
                "The total is " + playerSum + "\n\n" +
                "The dealer has a "+ dealer1 + " and " + dealer2 + "\n" +
                "Dealer's total is " + dealerSum + "\n");

        if(dealerSum >= playerSum){
            System.out.println("You lose!!");
        } else
            System.out.println("You win!!");

    }
}

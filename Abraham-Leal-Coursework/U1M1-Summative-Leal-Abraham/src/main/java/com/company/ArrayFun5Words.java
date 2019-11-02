package com.company;

import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Gets 5 words from the user
        System.out.println("Please enter five words: ");
        String word1, word2, word3, word4, word5;
        word1 = in.nextLine();
        word2 = in.nextLine();
        word3 = in.nextLine();
        word4 = in.nextLine();
        word5 = in.nextLine();

        //Puts words into an array
        String[] wordArray = {word1, word2, word3, word4, word5};

        //Prints the array elements to the screen.

        for (int i = 0; i < wordArray.length; i++){
            System.out.print(wordArray[i] + "\t");
        }

    }
}

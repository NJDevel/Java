package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter five numbers: ");
        int a,b,c,d,e;
        // Reads 5 ints from the user
        a = Integer.parseInt(in.nextLine());
        b = Integer.parseInt(in.nextLine());
        c = Integer.parseInt(in.nextLine());
        d = Integer.parseInt(in.nextLine());
        e = Integer.parseInt(in.nextLine());

        //Put values read from user in an array
        int[] outputArray = {a,b,c,d,e};

        //Prints the array elements to the screen
        for (int i = 0; i < outputArray.length; i++){
            System.out.print(outputArray[i] + "\t");
        }
    }

}

package com.company;

        import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Please enter a number:");
        num = in.nextInt();

        for (int i=0; i<=num; i++){
            System.out.println(i);
        }
    }
}

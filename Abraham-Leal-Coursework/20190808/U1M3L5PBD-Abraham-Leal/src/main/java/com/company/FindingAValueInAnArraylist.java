package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArraylist {

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int valueToFind;

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(50) + 1);
        }
        System.out.println("ArrayList : " + arrayList);

        System.out.print("Value to find: " );
        valueToFind = Integer.parseInt(in.nextLine());

        for (int a : arrayList){
            if (valueToFind == a){
                System.out.println("\n" + valueToFind + " is in the ArrayList.");
            }
        }
    }
}

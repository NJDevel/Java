package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GettingTheLargestValueInAnArraylist {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100) + 1);
        }
        System.out.println("ArrayList: " + arrayList);

        System.out.println("The largest number in this array is " +
                arrayList.stream().max(Comparator.comparingInt(Integer::intValue)).get());

    }

}

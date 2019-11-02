package com.company;

import java.util.ArrayList;
import java.util.Random;

public class BasicArraylists2 {

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100) + 1);
        }
        System.out.println("ArrayList: " + arrayList);
    }
}

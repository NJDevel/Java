package com.company;

import java.util.ArrayList;
import java.util.Random;

public class BasicArraylists3 {

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            arrayList.add(random.nextInt(89)+10);
        }
        System.out.println("Arraylist : " + arrayList);
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CopyingArraylists {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            arrayList.add(random.nextInt(100) + 1);
        }

        for (int a : arrayList){
            arrayList1.add(a);
        }

        arrayList.set(9, -7);

        System.out.println("Arraylist1 : " + arrayList);
        System.out.println("Arraylist2 : " + arrayList1);
    }
}

package com.company;

import java.util.ArrayList;

public class BasicArraylists1 {

    public static void main(String[] args) {
        int num = -113;
        ArrayList<Integer> arrayList= new ArrayList<>();

        for (int i = 0; i < 10; i++){
            arrayList.add(num);
        }

        for (int i = 0; i < arrayList.size(); i++){
            System.out.println("Slot "+ i + " contains a " + arrayList.get(i));
        }
    }


}

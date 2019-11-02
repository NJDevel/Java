package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class ClassmatesList {

    protected ArrayList<Classmate> list = new ArrayList<>();

    public void add(Classmate classmate){
        list.add(classmate);
    }
    public Classmate get(int a){
        return list.get(a);
    }

    public ArrayList<Classmate> getAll(){
        Iterator iterator = list.iterator();
        ArrayList<Classmate> outputArrayList = new ArrayList<>();
        for (Classmate classmate : list){
            outputArrayList.add(classmate);
        }
        return outputArrayList;
    }
}
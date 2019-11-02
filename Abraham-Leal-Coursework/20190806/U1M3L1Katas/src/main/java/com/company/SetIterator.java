package com.company;

import java.util.*;

public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e) {
        Set<Integer> integerMap = new HashSet<>();
        integerMap.add(a);
        integerMap.add(b);
        integerMap.add(c);
        integerMap.add(d);
        integerMap.add(e);

        Iterator iterator = integerMap.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

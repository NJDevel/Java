package com.company;

import java.util.*;

public class App {

    public static int total (ArrayList<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (ArrayList<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static ArrayList<String> swapFirstAndLast(ArrayList<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size()-1));
        strings.set(strings.size()-1, temp);

        return strings;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {

        ArrayList<Integer> reversed = new ArrayList();

        for(int i = 0; i < numbers.size(); i++) {
            reversed.add(i, numbers.get(numbers.size()- i -1));
        }

        return reversed;
    }

    public static ArrayList<Integer> lessThanFive(ArrayList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        ArrayList<Integer> lessThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.add(num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }

    //challenge
    public static int[][] splitAtFive(ArrayList<Integer> numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;


        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() < 5){
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            } else {
//                numMoreThanFive++;
//            }
//        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];

        Iterator<Integer> nextIterator = numbers.iterator();

        for (int num : numbers) {
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }


//        for(int num : numbers) {
//
//            // subtracting numLessThanFive from length then decrementing numLessThanFive
//            // allows us to go from 0 to length - 1 in order without additional variables
//            // same with numMoreThanFive
//            if ( num < 5 ) {
//                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            } else {
//                moreThan[moreThan.length - numMoreThanFive] = num;
//                numMoreThanFive--;
//            }
//        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(ArrayList<String> strings) {

        //leveraging integer division
        String[] odds = new String[ strings.size()/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.size() % 2 == 0) {
            evens = new String[ strings.size()/2];
        } else {
            evens = new String[ strings.size()/2 + 1];
        }

        for(int i = 0; i < strings.size(); i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings.get(i);
            } else {
                odds[currIndex] = strings.get(i);
            }
        }

        return new String[][] { evens, odds };
    }
}

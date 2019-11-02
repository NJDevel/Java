package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        // Declares an array with values [1, 2, 3, 4, 5],
        int [] array1 = {1,2,3,4,5};
        // Creates another array of equal length to first array
        int [] array2 = new int[array1.length];

        int reverseCounter = array1.length - 1;
        // Fills second array with values from the original array but in reverse order.
        for (int i = 0; i < array2.length; i++){
            array2[i] = array1[reverseCounter];
            if ( reverseCounter !=0)
            reverseCounter--;
        }

        // Prints the contents of both arrays to the screen.
        for (int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + "\t");
        }
    }
}

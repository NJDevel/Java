package com.company;

public class SomeMath {

    //Take 5 int parameters and returns the total
    public static int total5(int a, int b, int c, int d, int e) {

        int sum = 0;

        sum = a + b + c + d + e;

        return sum;
    }

    // Take 5 int parameters and return the average of the
    public static double average5(int a, int b, int c, int d, int e) {

        double avg;

        avg = (a + b + c + d + e) / 5;

        return avg;
    }

    // Take 5 double parameters and returns the largest.
    public static double largest5(double a, double b, double c, double d, double e) {

        double max;
        double[] maxArray = {a, b, c, d, e};

        int i = 0;
        if (maxArray[i] > maxArray[i + 1]) {
            max = maxArray[i];
        } else {
            max = maxArray[i + 1];
        }
        for (i = 1; i < maxArray.length; i++) {
            if (maxArray[i] > max) {
                max = maxArray[i];
            }
        }


        return max;
    }

    public static void main(String[] args) {

        //Calls the method total5 with the following parameters and prints the returned total to the
        // screen: 1, 2, 3, 4, 5.
        System.out.println(total5(1, 2, 3, 4, 5));

        // Calls the average5 method with the following parameters and prints the returned average
        // to the screen: 1, 3, 5, 7, 9.
        System.out.println(average5(1, 3, 5, 7, 9));

        // Calls the method largest5 with the following parameters and prints the returned value to the
        // screen: 42.0, 35.1, 2.3, 40.2, 15.6.
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));

    }
}

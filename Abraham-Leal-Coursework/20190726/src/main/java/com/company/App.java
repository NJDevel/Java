package com.company;

import java.util.Scanner;

public class App {
    int a;
    int b;
    int c;

    //Takes two int parameters (a and b) and returns the value of b subtracted from a.
    public static int subtract (int a, int b){

        return a - b;
    }

    /*
    Takes two int parameters (a and b) and returns the value of b subtracted from a,
    unless the result is less than zero, in which case, return 0.
    */
    public static int subtractOrZero (int a, int b){

        if ((a - b) < 0){
            return 0;
        } else {
            return a - b;
        }
    }

    /*
    Takes three int parameters (a, b, and c) and returns the value of the largest of the three.
     */
    public static int max (int a, int b, int c){

        if (a > b && a > c){
            return a;
        } else if (b > a && b > c){
            return c;
        } else {
            return c;
        }
    }

    /*
    Takes three int parameters (a, b, and c) and returns the value of the smallest of the three.
     */
    public static int min (int a, int b, int c){

        if (a < b && a < c){
            return a;
        } else if (b < a && b < c){
            return b;
        } else {
            return c;
        }
    }

    /*
    Takes two int parameters (first and second) and returns true if the first is greater than second.
     */
    public static boolean isLarger (int a, int b){


        if (a > b){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){

        //Test methods of the App class

        int x = 0;
        int y = 0;
        int z = 0;

        App app = new App();

        System.out.println(app.subtract(x, y));
        System.out.println(app.subtractOrZero(x, y));
        System.out.println(app.max(x, y, z));
        System.out.println(app.min(x, y, z));
        System.out.println(app.isLarger(x, y));

    }


}

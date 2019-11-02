package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;


public class AverageThree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        float a, b, c;

        System.out.println("Please input three numbers: ");

        /*
        a = in.nextLine();
        b = in.nextLine();
        c = in.nextLine();

         */

        a = Float.parseFloat(in.nextLine());
        b = Float.parseFloat(in.nextLine());
        c = Float.parseFloat(in.nextLine());


        float avg = (a + b + c)/ 3.00f;
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(avg));

        //System.out.println("The average is: "+ avg);



    }
}

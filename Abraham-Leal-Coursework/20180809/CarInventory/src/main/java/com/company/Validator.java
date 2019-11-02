package com.company;

import java.util.Scanner;

public interface Validator {

        Scanner in = new Scanner(System.in);

        static int validateInt(){
            int input = 0;
            if (in.hasNextInt()) {
                input = in.nextInt();
                in.nextLine();
                return input;
            } else {
                System.out.print("Invalid entry. Please try again: ");
                in.nextLine();
                input = validateInt();
            }
            return input;
        }
}



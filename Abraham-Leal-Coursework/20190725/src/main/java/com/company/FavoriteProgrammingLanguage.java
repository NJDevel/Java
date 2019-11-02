package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {
//Program will ask user to enter their favorite programming.  Will keep asking until "Java" is entered.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String lang;

        System.out.println("Please enter your favorite programming language: ");
        lang = in.nextLine();

        boolean flag = false;

        while (flag == false){
            if (lang.equals("Java")){
                System.out.println("That's what I was looking for! Java is definitely the answer!");
                flag = true;
            } else {
                System.out.println("Please enter your favorite programming language: ");
                lang = in.nextLine();
            }

        }
    }
}

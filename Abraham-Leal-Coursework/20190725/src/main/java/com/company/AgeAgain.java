package com.company;

import java.util.Scanner;

public class AgeAgain {
//Asks user age and a series a follow up questions depending on responses
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int age;
        String grade;
        String collegeBound;
        String college;
        String grad;

        System.out.println("Please enter your age: ");
        age = Integer.parseInt(in.nextLine());

        if (age < 14){
            System.out.println("What grade are you in? : ");
            grade =in.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        }

        else if (14 <= age && age <= 18){
            System.out.println("Are you planning on going to college? (yes/no): ");
            collegeBound = in.nextLine();
            if(collegeBound.equals("yes")){
                System.out.println("What college?");
                college = in.nextLine();
                System.out.println(college + " is a great school!");
            } else {
                System.out.println("What do you want to do after high school?");
                grad = in.nextLine();
                System.out.println("Wow, " + grad + " sounds like a plan!");
            }
        }

        else {
            System.out.println("What is your job?");
            String job = in.nextLine();
            System.out.println(job + " sounds like a great job!");
        }
    }
}

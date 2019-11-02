package com.company;

import java.util.Scanner;

public class YourAgeCan {
//Asks user for age and lists activities the user can take part in
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int age;

        System.out.println("Please enter your age: ");
        age = in.nextInt();

        if (age >= 18 && age >= 21 && age >= 35 && age >= 55 && age >= 65 && age >= 80 && age > 100) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
            System.out.println(age + " is old enough to join AARP.");
            System.out.println(age + " is old enough to retire.");
            System.out.println(age + " is the age of an octogenerian.");
            System.out.println(age + " is more than a century old.");
        } else if (age >= 18 && age >= 21 && age >= 35 && age >= 55 && age >= 65 && age >= 80 && age > 100) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
            System.out.println(age + " is old enough to join AARP.");
            System.out.println(age + " is old enough to retire.");
            System.out.println(age + " is the age of an octogenerian.");
            System.out.println(age + " is more than a century old.");
        } else if (age >= 18 && age >= 21 && age >= 35 && age >= 55 && age >= 65 && age >= 80) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
            System.out.println(age + " is old enough to join AARP.");
            System.out.println(age + " is old enough to retire.");
            System.out.println(age + " is the age of an octogenerian.");
        } else if (age >= 18 && age >= 21 && age >= 35 && age >= 55 && age >= 65) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
            System.out.println(age + " is old enough to join AARP.");
            System.out.println(age + " is old enough to retire.");
        } else if (age >= 18 && age >= 21 && age >= 35 && age >= 55) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
            System.out.println(age + " is old enough to join AARP.");
        } else if (age >= 18 && age >= 21 && age >= 35) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
            System.out.println(age + " is old enough to be president.");
        } else if (age >= 18 && age >= 21) {
            System.out.println(age + " is old enough to drink alcohol.");
            System.out.println(age + " is old enough to vote.");
        } else if (age >= 18) {
            System.out.println(age + " is old enough to vote.");
        }
    }
}

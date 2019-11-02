package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {

    Scanner in = new Scanner(System.in);
    int inputInt;
    long inputLong;
    double inputDouble;
    float inputFloat;
    String inputString;

    public BetterInput(){}

    public int readInt(String prompt){
        System.out.println(prompt);
        try {
            inputInt = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Entry!");
            readInt(prompt);
        }
        return inputInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        try {
            inputLong = Long.parseLong(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Entry!");
            readLong("Enter a long");
        }
        return inputLong;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        try {
            inputDouble = Double.parseDouble(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Entry!");
            readDouble("Enter a double");
        }
        return inputDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        try {
            inputFloat = Float.parseFloat(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Entry!");
            readFloat("Enter a float");
        }
        return inputFloat;
    }

    public String readString(String prompt){
        System.out.println(prompt);
        try {
            inputString = in.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Entry!");
            readString("Enter a String");
        }
        return inputString;
    }

}

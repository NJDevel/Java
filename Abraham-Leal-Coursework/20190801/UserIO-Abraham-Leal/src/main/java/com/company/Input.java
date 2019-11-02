package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner in = new Scanner(System.in);
    String input;

    public Input(){}

    public int readInt(String prompt){
        System.out.print(prompt);
        input = in.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public long readLong(String prompt) {
        System.out.print(prompt);
        input = in.nextLine();
        return Long.parseLong(input);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.print(prompt);
        input = in.nextLine();
        return Double.parseDouble(input);
    }

    @Override
    public float readFloat(String prompt) {
        System.out.print(prompt);
        input = in.nextLine();
        return Float.parseFloat(input);
    }

    public String readString(String prompt){
        System.out.print(prompt);
        input = in.nextLine();
        return input;
    }
}

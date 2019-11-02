package com.company;

public class Calculator {

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int division(int a, int b){
        return a / b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public double subtract(double a, double b){
        return a - b ;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        return a / b;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        //Integer math
        System.out.println("Integer addition. 1 + 1 = " + calculator.add(1,1));
        System.out.println("Integer subtraction. 23 - 52 = " + calculator.subtract(23, 52));
        System.out.println("Integer multiplication. 34 * 2 = " + calculator.multiply(34, 2));
        System.out.println("Integer division. 12 / 3 = " + calculator.division(12,3));
        System.out.println("Integer division. 12 / 7 = " + calculator.division(12,7));
        //Double math
        System.out.println("Double addition. 3.4 + 2.3 = " + calculator.add(3.4,2.3));
        System.out.println("Double multiplication. 6.7 * 4.4 = " + calculator.multiply(6.7,4.4));
        System.out.println("Double subtraction. 5.5 - 0.5 = " + calculator.subtract(5.5,0.5));
        System.out.println("Double division. 10.8 / 2.2 = " + calculator.divide(10.8,2.2));
    }

}

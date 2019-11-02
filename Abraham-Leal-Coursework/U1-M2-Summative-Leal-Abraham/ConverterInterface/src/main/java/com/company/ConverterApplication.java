package com.company;

public class ConverterApplication {

    public static void main(String[] args) {

        ConverterIf converterIf = new ConverterIf();
        ConverterSwitch converterSwitch = new ConverterSwitch();


        //ConverterIf implementation
        System.out.println("I was born on "+ converterIf.convertMonth(6) + " 29th, 1986 which " +
                "turns out to have been a "+ converterIf.convertDay(1) + ".");
        //ConverterSwitch implementation
        System.out.println("My father was born on " + converterSwitch.convertMonth(7) + " 25th 1942, which " +
                "fell on a " + converterSwitch.convertDay(4) + ".");

    }
}

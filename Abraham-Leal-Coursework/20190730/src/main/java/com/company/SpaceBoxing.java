package com.company;

import java.util.Scanner;

public class SpaceBoxing {

    //t should ask him what his earth weight is, and to enter a number for the planet he wants to fight on.
    // It should then compute his weight on the destination planet based on the table below:
    //
    //#	Planet	Relative gravity
    //1	Venus	0.78
    //2	Mars	0.39
    //3	Jupiter	2.65
    //4	Saturn	1.17
    //5	Uranus	1.05
    //6	Neptune	1.23
    //So, for example, if Julio weighs 128 lbs. on earth, then he would weigh just under 50 lbs. on Mars,
    // since Mars' gravity is 0.39 times earth's gravity. (128 * 0.39 is 49.92)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your current earth weight: ");
        float weight = Float.parseFloat(in.nextLine());

        System.out.println("I have information on the following planets: \n1. Venus \t2. Mars\t\t3. Jupiter\n4. Saturn\t" +
                "5. Uranus\t6. Nepture\nWhich planet are you visiting?");
        int planet = Integer.parseInt(in.nextLine());

        if (planet == 1){
            weight = weight*.78f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else if (planet == 2){
            weight = weight*.39f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else if(planet == 3){
            weight = weight*2.65f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else if(planet == 4){
            weight = weight*1.17f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else if(planet == 5){
            weight = weight*1.05f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else if(planet == 6){
            weight = weight*1.23f;
            System.out.printf("Your weight would be %.2f pounds on that planet.", weight);
        } else {
            System.out.println("Entered an invalid planet number!");
        }


    }

}



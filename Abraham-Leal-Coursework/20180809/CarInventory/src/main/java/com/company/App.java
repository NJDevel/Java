package com.company;

import java.util.Scanner;

public class App implements CarInventory {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean go = true;
        boolean validChoice = false;
        int userChoice = 0;

        System.out.println("Welcome to Abe's Car Inventory Program");

        while (go == true) {
            while (validChoice == false) {
                //Main Menu
                System.out.print("Please choose an option:\n" +
                        "1. Add a car\n" +
                        "2. Delete a car\n" +
                        "3. List cars in inventory\n" +
                        "4. Search Inventory\n" +
                        "5. Exit the program\n");

                userChoice = Validator.validateInt();
                    if (userChoice > 0 && userChoice < 6) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid selection. Try again.");
                        userChoice = in.nextInt();
                    }
            }

            validChoice = false;
            //Calls method depending on user choice
            switch (userChoice){
                case 1:
                    CarInventory.addCar();
                    break;
                case 2:
                    CarInventory.deleteCar();
                    break;
                case 3:
                    CarInventory.listCars(CarInventory.carInventory);
                    break;
                case 4:
                    CarInventory.searchCars();
                    break;
                case 5:
                    go = CarInventory.exitProgram();
                    break;
            }
            userChoice = 0;

        }
    }
}


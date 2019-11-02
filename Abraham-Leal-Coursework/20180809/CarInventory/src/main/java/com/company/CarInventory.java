package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public interface CarInventory extends Validator {

    ArrayList<Car> carInventory = new ArrayList<>();
    Scanner in = new Scanner(System.in);


    static void addCar() {
        String make = "";
        String model = "";
        int year = 0;
        String color = "";
        int milesOdometer = 0;
        boolean go = true;
        boolean validChoice = false;
        int userChoice = 0;


        while (go == true) {
            System.out.print("You must enter all car attributes and confirm to create add car to Inventory.\n" +
                    "Please enter the car make: ");
            make = in.nextLine();  //Place holder for checking logic of make entry

            System.out.print("Please enter the car model: ");
            model = in.nextLine(); //Place holder for checking logic of model entry

            System.out.print("Please enter the year of the car's production: ");
            year = Validator.validateInt();

            System.out.print("Please enter the car's color: ");
            color = in.nextLine(); //Place holder for checking logic of model entry

            System.out.print("Please enter the miles on the odometer: ");
            milesOdometer = Validator.validateInt();

            System.out.print("\n*****************************************" +
                    "\nCar make: " + make +
                    "\nCar model: " + model +
                    "\nCar year: " + year +
                    "\nCar color: " + color +
                    "\nCar miles: " + milesOdometer +
                    "\n*****************************************");

            System.out.print("\n\nPlease confirm the information is correct or exit to main menu: " +
                    "\n1. Confirm and add car to inventory." +
                    "\n2. Re-enter car attributes" +
                    "\n3. Exit to main menu\n");

            userChoice = Validator.validateInt();

            switch (userChoice) {
                case 1:
                    Car car = new Car(make, model, year, color, milesOdometer);
                    carInventory.add(car);
                    go = false;
                    break;
                case 2:
                    go = true;
                    break;
                case 3:
                    go = false;
                    break;
            }
        }
        return;
    }

    static void listCars(ArrayList<Car> carInventory) {
        for (int i = 0; i < carInventory.size(); i++) {
            System.out.println("******************************\nCar Number: " + i +
                    "\nCar Model: " + carInventory.get(i).getModel() +
                    "\nCar Make: " + carInventory.get(i).getMake() +
                    "\nCar Year: " + carInventory.get(i).getYear() +
                    "\nCar Color: " + carInventory.get(i).getColor() +
                    "\nCar Mileage: " + carInventory.get(i).getMilesOdometer() +
                    "\n******************************");
        }
        return;
    }

    static void deleteCar() {
        int userChoice = 0;
        String choice;
        boolean go = true;
        System.out.println("Please enter one of the following options. " +
                "\n1. List full inventory cars" +
                "\n2. Search inventory by criteria");
        userChoice = Validator.validateInt();

        switch (userChoice) {
            case 1:
                listCars(carInventory);
                while (go == true) {
                    System.out.println("\nPlease pick a number of the car to delete: ");
                    userChoice = Validator.validateInt();
                    while (go == true) {
                        if (userChoice < 0 || userChoice > carInventory.size()) {
                            System.out.print("Invalid Entry. Try Again. ");
                            userChoice = Validator.validateInt();
                        } else {
                            go = false;
                        }
                    }
                    System.out.println("Are you certain you want to delete car " + userChoice + " ?!?" +
                            "(y/n)");
                    choice = in.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        carInventory.remove(userChoice);
                    } else {
                        System.out.println("Better safe than sorry!");
                    }
                }
                break;
            case 2:
                searchCars();
                while (go == true) {
                    System.out.println("\nPlease pick a number of the car to delete: ");
                    userChoice = Validator.validateInt();
                    while (go == true) {
                        if (userChoice < 0 || userChoice > carInventory.size()) {
                            System.out.print("Invalid Entry. Try Again. ");
                            userChoice = Validator.validateInt();
                        } else {
                            go = false;
                        }
                    }
                    System.out.println("Are you certain you want to delete car " + userChoice + " ?!?" +
                            "(y/n)");
                    choice = in.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        carInventory.remove(userChoice);
                    } else {
                        System.out.println("Better safe than sorry!\n");
                    }
                }
                break;
        }
        return;
    }

    static void searchCars() {
        String makeChoice = "";
        String modelChoice = "";
        int yearChoice = 0;
        String colorChoice = "";
        int milesOdometerChoice = 0;
        int choice;
        String choice1;
        boolean go = true;
        int userChoice = 0;

        System.out.println("Please select one of the following criteria to search inventory by. " +
                "\n1. Make" +
                "\n2. Model" +
                "\n3. Year" +
                "\n4. Color" +
                "\n5. Mileage");

        choice = Validator.validateInt();

        switch (choice) {
            case 1:
                System.out.println("Please enter the make you are looking for: ");
                makeChoice = in.nextLine();
                String make = makeChoice;
                carInventory.stream().filter(car -> car.getMake().equalsIgnoreCase(make)).forEach(c -> {
                    System.out.println("******************************" +
                            "\nCar Number: " + carInventory.indexOf(c) +
                            "\nCar Model: " + c.getMake() +
                            "\nCar Make: " + c.getMake() +
                            "\nCar Year: " + c.getYear() +
                            "\nCar Color: " + c.getColor() +
                            "\nCar Mileage: " + c.getMilesOdometer() +
                            "\n******************************");
                });
                break;

            case 2:
                System.out.println("Please enter the model you are looking for: ");
                modelChoice = in.nextLine();
                String model = modelChoice;
                carInventory.stream().filter(car -> car.getModel().equalsIgnoreCase(model)).forEach(c -> {
                    System.out.println("******************************" +
                            "\nCar Number: " + carInventory.indexOf(c) +
                            "\nCar Model: " + c.getMake() +
                            "\nCar Make: " + c.getMake() +
                            "\nCar Year: " + c.getYear() +
                            "\nCar Color: " + c.getColor() +
                            "\nCar Mileage: " + c.getMilesOdometer() +
                            "\n******************************");
                });
                break;

            case 3:
                System.out.println("Please enter the year you are looking for: ");
                yearChoice = Validator.validateInt();
                int year = yearChoice;
                carInventory.stream().filter(car -> car.getYear() == year)
                        .forEach(c -> {
                    System.out.println("******************************" +
                            "\nCar Number: " + carInventory.indexOf(c) +
                            "\nCar Model: " + c.getMake() +
                            "\nCar Make: " + c.getMake() +
                            "\nCar Year: " + c.getYear() +
                            "\nCar Color: " + c.getColor() +
                            "\nCar Mileage: " + c.getMilesOdometer() +
                            "\n******************************");
                });
                break;

            case 4:
                System.out.println("Please enter the color you are looking for: ");
                colorChoice = in.nextLine();
                String color = colorChoice;
                carInventory.stream().filter(car -> car.getColor().equals(color)).forEach(c -> {
                    System.out.println("******************************" +
                            "\nCar Number: " + carInventory.indexOf(c) +
                            "\nCar Model: " + c.getMake() +
                            "\nCar Make: " + c.getMake() +
                            "\nCar Year: " + c.getYear() +
                            "\nCar Color: " + c.getColor() +
                            "\nCar Mileage: " + c.getMilesOdometer() +
                            "\n******************************");
                });
                break;

            case 5:
                //Later change this to take has less than this many miles
                System.out.println("Please enter the year you are looking for: ");
                milesOdometerChoice = Validator.validateInt();
                int milesOdometer = milesOdometerChoice;
                carInventory.stream().filter(car -> car.getMilesOdometer()== milesOdometer)
                        .forEach(c -> {
                            System.out.println("******************************" +
                                    "\nCar Number: " + carInventory.indexOf(c) +
                                    "\nCar Model: " + c.getMake() +
                                    "\nCar Make: " + c.getMake() +
                                    "\nCar Year: " + c.getYear() +
                                    "\nCar Color: " + c.getColor() +
                                    "\nCar Mileage: " + c.getMilesOdometer() +
                                    "\n******************************");
                        });
                break;
        }
        return;
    }
    static boolean exitProgram() {
        return false;
    }
}

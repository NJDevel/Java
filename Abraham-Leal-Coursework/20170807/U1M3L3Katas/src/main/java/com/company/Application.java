package com.company;

import java.io.IOException;
import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();

            int petIndex = Pets.choosePet();

            String chosenPet = Pets.retrievePet(petIndex);

            Pets.writePetToFile(chosenPet);

            System.out.println("New saved animals file:");
            Pets.readPetsFromFile();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number: " + e.getMessage());
        } catch (IOException e){
            System.out.println("The following file does not seem to exist: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please choose an available pet");
        } finally {
            System.out.println("Have a nice day!");
        }


    }
}

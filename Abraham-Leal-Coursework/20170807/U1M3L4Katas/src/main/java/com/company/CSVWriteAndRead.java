package com.company;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVWriteAndRead {

    public static void main(String[] args) throws IOException {

        CSVReader reader = null;
        String[] currentCells = new String[0];
        String[] headings = new String[0];

        try {

            List<Car> carList = new ArrayList<>();

            carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
            carList.add(new Car(2001, "Honda", "Civic", "Silver"));
            carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
            carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
            carList.add(new Car(1964, "Ford", "Mustang", "Red"));

            // Writes the car list to a file
            Writer writer = new FileWriter("carList.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }

        try {
            reader = new CSVReader(new FileReader("carList.csv"));

            // Read the first line (if it exists) - this is the header row.  We'll print out the headers
            headings = reader.readNext();
            if (headings != null) {
                for (String heading : headings) {
                    System.out.println(heading);
                }
            }

            while ((currentCells = reader.readNext()) != null) {
                System.out.println("=====================================");
                for (int i = 0; i < currentCells.length; i++) {
                    System.out.println(headings[i] + " : " + currentCells[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not read row from file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CVS file is malformed.  Perhaps some of your rows have too many columns??? ");
        }
    }

}


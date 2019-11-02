package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ComputerReader {

    public static void main (String[] args) throws IOException {

        List<Computer> computers = new CsvToBeanBuilder<Computer>(new FileReader("computers.csv"))
                .withType(Computer.class).build().parse();

        computers
                    .stream()
                    .forEach(computer -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + computer.getBrand());
                        System.out.println("Model: " + computer.getModel());
                        System.out.println("CPU: " + computer.getCpu());
                        System.out.println("RAM: " + computer.getRam());
                        System.out.println("Storage Size: " + computer.getStorageSize());
                    });

    }

}

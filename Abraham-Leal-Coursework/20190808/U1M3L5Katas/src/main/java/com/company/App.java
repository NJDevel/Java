package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class App {

    public static void main(String[] args) {

        try {

            //Reads data from .json file and stores in List.
            ObjectMapper mapper = new ObjectMapper();
            List<Television> tvList;
            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            //Finds all tvs with screen size greater than 60 inches
            int screenSize = 60;
            tvList
                    .stream()
                    .filter(tv -> tv.getScreenSize() > screenSize)
                    .forEach(tv -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                    });

            System.out.println("\n=================================\n" +
                    "List of Television Brands\n" +
                    "=================================");
            //Groups all televisions into Map by brand.
            Map<String, List<Television>> groupedTvs =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(tv -> tv.getBrand()));

            Set<String> keys = groupedTvs.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            //Finds and displays the average screen size
            System.out.println("\n=================================\n" +
                    "Average Television Screen Size\n" +
                    "=================================");
            double avgScreenSize =
                    tvList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average television screen size is: " + avgScreenSize);

            //Finds and displays the largest screen
            System.out.println("\n=================================\n" +
                    "Largest Television Screen Size\n" +
                    "=================================");
            int maxScreenSize =
                    tvList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("The largest television television screen size: " + maxScreenSize);

            //Challenge : Sorts data by screen size and prints sorted list
            System.out.println("\n=================================\n" +
                    "Sorted Television list by Screen Size\n");

            List<Television> sortedTvs =
                    tvList
                            .stream()
                            .sorted(Comparator.comparingInt(Television::getScreenSize))
                            .collect(Collectors.toList());

            sortedTvs
                    .forEach(tv -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                    });

        } catch (FileNotFoundException e){
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



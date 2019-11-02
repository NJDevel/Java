package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelevisionReader {

    public static void main(String[] args) throws IOException {

        List<Television> tvList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
        });

        tvList
                .stream()
                .forEach(television -> {
                    System.out.println("===============");
                    System.out.println("Brand: " + television.getBrand());
                    System.out.println("Model: " + television.getModel());
                    System.out.println("Price: " + television.getPrice());
                    System.out.println("Screen Size: " + television.getScreenSize());
                });



    }
}

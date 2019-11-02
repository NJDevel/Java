package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneReader {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        List<Phone> phoneList = new ArrayList<>();

        phoneList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>(){});

        for (Phone phone : phoneList) {
            System.out.println("================");
            System.out.println("Brand: " + phone.getBrand());
            System.out.println("Model: " + phone.getModel());
            System.out.println("Processor: " + phone.getProcessor());
            System.out.println("Storage: " + phone.getStorage() + "GB");
            System.out.println("Price: $" + phone.getPrice());
        }
    }
}

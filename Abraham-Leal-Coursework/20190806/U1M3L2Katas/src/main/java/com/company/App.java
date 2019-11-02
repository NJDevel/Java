package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> a) {

        Set<Map.Entry<String, String>> myEntries = a.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = myEntries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry tempEntry = entryIterator.next();
            System.out.println(tempEntry.getKey());
        }
    }

    public void printValues(Map<String, String> a) {
        Set<Map.Entry<String, String>> myEntries = a.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = myEntries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry tempEntry = entryIterator.next();
            System.out.println(tempEntry.getValue());
        }
    }

    public void printKeysAndValues(Map<String, String> a) {
        Set<Map.Entry<String, String>> myEntries = a.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = myEntries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry tempEntry = entryIterator.next();
            System.out.println(tempEntry.getKey() + ": " + tempEntry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> a) {

        a.put("Ford Explorer", 2012);
        a.put("Smart Fortwo", 2013);

        a.remove("Jeep Wrangler");

        return a;
    }

    public Map<String, List<Car>> listCars(List<Car> a) {
        List<Car> toyotaList, fordList, hondaList;
        toyotaList = new ArrayList<>();
        fordList = new ArrayList<>();
        hondaList = new ArrayList<>();

        for (Car car : a) {
            if (car.getMake().equals("Toyota")) {
                toyotaList.add(car);
            } else if (car.getMake().equals("Ford")) {
                fordList.add(car);
            } else if (car.getMake().equals("Honda")) {
                hondaList.add(car);
            }
        }
        Map<String, List<Car>> outputMap = new HashMap<>();

        for (Car car : toyotaList){
            outputMap.put(car.getMake(), toyotaList);
        }

        for (Car car : fordList){
            outputMap.put(car.getMake(), fordList);
        }

        for (Car car : hondaList) {
            outputMap.put(car.getMake(), hondaList);
        }

        return outputMap;

    }


}

package com.company;

import java.util.*;

public class City {

    protected String name;
    protected double population;
    protected String stateName;

    public City(String name, double population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public static void main(String[] args) {
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> map = new HashMap<>();
        map.put("New York", newYork);
        map.put("California", losAngeles);
        map.put("Illinois", chicago);
        map.put("Colorado", denver);
        map.put("Iowa", desMoines);
        map.put("Georgia", atlanta);

        Iterator<String> keySetIterator = map.keySet().iterator();

        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println(map.get(key).getName() + ", " + key + ". Population : " + map.get(key).getPopulation());
        }
        System.out.println();
        Scanner in = new Scanner(System.in);
        double pop;
        System.out.print("Please enter a population number: ");
        pop = Float.parseFloat(in.nextLine());

        Iterator<String> popSetIterator = map.keySet().iterator();

        System.out.println("The below cities have a greater population than the one entered: \n");

        while (popSetIterator.hasNext()) {
            String key = popSetIterator.next();
            if (pop <= map.get(key).getPopulation()) {
                System.out.println(map.get(key).getName() + ", " + key + ". Population : " + map.get(key).getPopulation());
            }
        }
    }
}


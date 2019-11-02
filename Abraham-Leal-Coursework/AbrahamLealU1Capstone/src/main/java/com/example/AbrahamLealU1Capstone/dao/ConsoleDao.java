package com.example.AbrahamLealU1Capstone.dao;

import com.example.AbrahamLealU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int id);

    List<Console> searchConsoleByManufacturer(String manufacturer);

    int getInventoryQuantity(int id);
}

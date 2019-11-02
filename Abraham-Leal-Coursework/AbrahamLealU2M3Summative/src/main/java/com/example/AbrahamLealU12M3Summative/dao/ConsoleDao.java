package com.example.AbrahamLealU12M3Summative.dao;

import com.example.AbrahamLealU12M3Summative.model.Console;

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

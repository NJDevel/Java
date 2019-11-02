package com.example.AbrahamLealU12M3Summative.controllers;

import com.example.AbrahamLealU12M3Summative.model.Console;
import com.example.AbrahamLealU12M3Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    /**************************************************************
     Console API
     **************************************************************/
    @RequestMapping(value = "/consoles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        console = serviceLayer.saveConsole(console);
        return console;
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles(){
        return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid Console console){
        serviceLayer.updateConsole(console);
    }

    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int consoleId){
        return serviceLayer.findConsole(consoleId);
    }

    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int consoleId){
        serviceLayer.deleteConsole(consoleId);
    }

    @RequestMapping(value = "/consolesByManufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> searchConsoleByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.findConsoleByManufacturer(manufacturer); }
}

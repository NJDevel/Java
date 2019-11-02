package com.example.AbrahamLealU12M3Summative.controllers;

import com.example.AbrahamLealU12M3Summative.model.Tshirt;
import com.example.AbrahamLealU12M3Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtController {

    @Autowired
    ServiceLayer serviceLayer;

    /**************************************************************
     T-Shirt API
     **************************************************************/
    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Tshirt createTshirt(@RequestBody @Valid Tshirt tshirt) {
        tshirt = serviceLayer.saveTshirt(tshirt);
        return tshirt;
    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getAllTshirts(){
        return serviceLayer.findAllTshirts();
    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTshirt(@RequestBody @Valid Tshirt tshirt){
        serviceLayer.updateTshirt(tshirt);
    }

    @RequestMapping(value = "/tshirts/{tshirtId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int tshirtId){
        return serviceLayer.findTshirt(tshirtId);
    }

    @RequestMapping(value = "/tshirts/{tshirtId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int tshirtId){
        serviceLayer.deleteTshirt(tshirtId);
    }

    @RequestMapping(value = "/tshirtsByColor/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> searchTshirtsByColor(@PathVariable String color) {return serviceLayer.findTshirtByColor(color); }

    @RequestMapping(value = "/tshirtsBySize/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> searchTshirtBySize(@PathVariable String size) {return serviceLayer.findTshirtBySize(size); }

}

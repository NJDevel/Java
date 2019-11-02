package com.example.AbrahamLealU12M3Summative.controllers;

import com.example.AbrahamLealU12M3Summative.model.*;
import com.example.AbrahamLealU12M3Summative.service.ServiceLayer;
import com.example.AbrahamLealU12M3Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RentalStoreController {

    @Autowired
    ServiceLayer serviceLayer;

    /**************************************************************
     Purchase API
     **************************************************************/

    @RequestMapping(value = "/purchases", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel makePurchase(@RequestBody @Valid Purchase purchase) {
        return serviceLayer.makePurchase(purchase);
    }

    @GetMapping(value = "/allDone")
    public String allDone() {
        return "You have successfully logged out!";
    }

}



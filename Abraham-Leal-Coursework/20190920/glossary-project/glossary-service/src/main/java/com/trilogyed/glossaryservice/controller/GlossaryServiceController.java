package com.trilogyed.glossaryservice.controller;

import com.trilogyed.glossaryservice.models.Definition;
import com.trilogyed.glossaryservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GlossaryServiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    GlossaryServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping(value = "/glossary/term/{term}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Definition> findDefinition(@PathVariable String term) {
        return serviceLayer.findDefinition(term);
    }

    @RequestMapping(value = "/glossary", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Definition saveDefinition(@RequestBody Definition definition) {
        return serviceLayer.saveDefinition(definition);
    }
}

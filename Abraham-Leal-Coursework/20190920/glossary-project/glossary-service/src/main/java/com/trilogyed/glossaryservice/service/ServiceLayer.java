package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.exception.NaughtyWordException;
import com.trilogyed.glossaryservice.models.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    private DefinitionServiceClient definitionServiceClient;

    private final String[] forbiddenWords = {"darn", "heck", "drat", "jerk", "butt"};

    public ServiceLayer(DefinitionServiceClient definitionServiceClient) {
        this.definitionServiceClient = definitionServiceClient;
    }

    public List<Definition> findDefinition(String term) {
        return definitionServiceClient.getDefinitionsForTerm(term);
    }

    public Definition saveDefinition(Definition definition) {
        String[] definitionWords = definition.getDefinition().split(" ");

        for(String definitionWord : definitionWords) {
            for(String word: forbiddenWords) {
                if(definitionWord.equalsIgnoreCase(word));
                throw new NaughtyWordException("Please do not use a naughty word in your definition!");
            }
        }

        return definitionServiceClient.addDefinition(definition);
    }
}

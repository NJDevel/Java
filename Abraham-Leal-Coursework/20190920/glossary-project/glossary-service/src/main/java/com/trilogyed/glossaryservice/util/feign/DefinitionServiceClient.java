package com.trilogyed.glossaryservice.util.feign;

import com.trilogyed.glossaryservice.models.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "definition-service")
public interface DefinitionServiceClient {

    @RequestMapping(value = "/definition/term/{term}", method = RequestMethod.GET)
    public List<Definition> getDefinitionsForTerm(@PathVariable String term);

    @RequestMapping(value = "/definition", method = RequestMethod.POST)
    public Definition addDefinition(@RequestBody Definition definition);

    @RequestMapping(value = "/definition/{id}", method = RequestMethod.GET)
    public Definition getDefinition(@PathVariable int id);
}

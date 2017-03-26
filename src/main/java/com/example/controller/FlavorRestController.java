package com.example.controller;

import com.example.domain.Flavor;
import com.example.domain.Producer;
import com.example.service.FlavorService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hubertus on 3/26/17.
 */
@RestController
@RequestMapping(value = "/flavor")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FlavorRestController {

    @Autowired
    private FlavorService flavorService;

    @GetMapping
    public MappingJacksonValue getProducers(){
        List<Flavor> flavors = flavorService.listFlavor();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(flavors);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Flavor", SimpleBeanPropertyFilter.serializeAllExcept(""));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue registerCustomer(@RequestBody Flavor flavor){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(flavorService.addFlavor(flavor));
        FilterProvider filters = new SimpleFilterProvider().addFilter("Flavor", SimpleBeanPropertyFilter.serializeAllExcept(""));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue updateCategory(@RequestBody Flavor flavor){
        this.flavorService.updateFlavor(flavor);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Flavor", SimpleBeanPropertyFilter.serializeAllExcept(""));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(flavor);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteCategory(@PathVariable Short id){
        this.flavorService.removeFlavor(id);
    }
}

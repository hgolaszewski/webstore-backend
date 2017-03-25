package com.example.controller;

import com.example.domain.Category;
import com.example.domain.Producer;
import com.example.service.ProducerService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/producers")
public class ProducerRestController {

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public MappingJacksonValue getProducers(){
        List<Producer> producers = producerService.listProducers();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(producers);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Producer", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue registerCustomer(@RequestBody Producer producer){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(producerService.addProducer(producer));
        FilterProvider filters = new SimpleFilterProvider().addFilter("Producer", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue updateCategory(@RequestBody Producer producer){
        this.producerService.updateProducer(producer);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Producer", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(producer);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteCategory(@PathVariable Short id){
        this.producerService.deleteProducer(id);
    }

}

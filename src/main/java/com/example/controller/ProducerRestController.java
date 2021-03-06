package com.example.controller;

import com.example.domain.Producer;
import com.example.service.ProducerService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */

@RestController
public class ProducerRestController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/producers")
    public MappingJacksonValue getProducers(){

        List<Producer> producers = producerService.listProducers();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(producers);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Producer", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }


}

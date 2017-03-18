package com.example.controller;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hubertus on 3/16/17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/registration")
public class RegisterRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue registerCustomer(@RequestBody Customer customer){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(customerService.addCustomer(customer));
        FilterProvider filters = new SimpleFilterProvider().addFilter("Customer", SimpleBeanPropertyFilter.serializeAllExcept("address", "order"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}

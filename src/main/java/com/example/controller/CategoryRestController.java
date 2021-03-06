package com.example.controller;

import com.example.domain.Category;
import com.example.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */

@RestController
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/categories")
    public MappingJacksonValue getCategories(){
        List<Category> users = categoryService.listCategories();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }


}

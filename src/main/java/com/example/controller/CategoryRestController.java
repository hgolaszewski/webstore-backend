package com.example.controller;

import com.example.domain.Category;
import com.example.service.CategoryService;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public MappingJacksonValue getCategories(){
        List<Category> users = categoryService.listCategories();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue createCategory(@RequestBody Category category){
        this.categoryService.addCategory(category);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(category);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MappingJacksonValue updateCategory(@RequestBody Category category){
        this.categoryService.updateCategory(category);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(category);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteCategory(@PathVariable Short id){
        this.categoryService.deleteCategory(id);
    }


}

package com.example.controller;

import com.example.domain.Opinion;
import com.example.domain.Product;
import com.example.service.OpinionService;
import com.example.service.ProductService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hubertus on 3/9/17.
 */
@RestController
public class OpinionRestController {

    @Autowired
    private OpinionService opinionService;
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/opinions/productId={id}")
    public MappingJacksonValue getOpinions(@PathVariable("id") short productId){
        Product product = productService.getProductById(productId);
        List<Opinion> opinions = opinionService.listOpinionsByProduct(product);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(opinions);
        FilterProvider filters = new SimpleFilterProvider().addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}

package com.example.controller;

import com.example.domain.Producer;
import com.example.domain.Product;
import com.example.domain.ProductPack;
import com.example.service.ProductPackService;
import com.example.service.ProductService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hubertus on 3/20/17.
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class ProductRestController {

    @Autowired
    ProductPackService productPackService;

    @GetMapping(value = "/mainPageProducts")
    public MappingJacksonValue getProduct(){

        List<ProductPack> productPacks = productPackService.listForMainPage(5);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productPacks);
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        simpleFilterProvider.addFilter("ProductPack", SimpleBeanPropertyFilter.serializeAllExcept("productsPacksFlavor"));
        simpleFilterProvider.addFilter("Category", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        simpleFilterProvider.addFilter("Producer", SimpleBeanPropertyFilter.serializeAllExcept("products"));
        simpleFilterProvider.addFilter("Product", SimpleBeanPropertyFilter.serializeAllExcept("description", "opinions", "productsPacks"));
        FilterProvider filters = simpleFilterProvider;
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}

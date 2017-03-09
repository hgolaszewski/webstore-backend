package com.example.controller;

import com.example.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.CategoryService;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */

@RestController
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.listCategories();
    }


}

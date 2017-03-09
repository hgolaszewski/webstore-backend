package com.example.controller;

import com.example.domain.Producer;
import com.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam on 3/9/17.
 */

@RestController
public class ProducerRestController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/producers")
    public Iterable<Producer> getProducers(){
        return producerService.listProducers();
    }


}

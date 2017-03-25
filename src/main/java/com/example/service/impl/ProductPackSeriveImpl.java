package com.example.service.impl;

import com.example.domain.ProductPack;
import com.example.repository.ProductPackRepository;
import com.example.service.ProductPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hubertus on 3/22/17.
 */
@Service
@Transactional
public class ProductPackSeriveImpl implements ProductPackService {

    @Autowired
    ProductPackRepository productPackRepository;

    @Override
    public List<ProductPack> listForMainPage(int quantity) {

        return productPackRepository.findFirst24ByOrderByPriceDesc();
    }
}

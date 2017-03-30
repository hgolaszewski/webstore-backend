package com.example.service;

import com.example.domain.ProductPack;

import java.util.List;

/**
 * Created by hubertus on 3/22/17.
 */
public interface ProductPackService {
    List<ProductPack> listForMainPage(int quantity);
    ProductPack getProductPackById(short id);
}

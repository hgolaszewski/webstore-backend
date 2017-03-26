package com.example.repository;

import com.example.domain.ProductPack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adam on 3/8/17.
 */
public interface ProductPackRepository extends JpaRepository<ProductPack, Short> {
    public List<ProductPack> findFirst24ByOrderByPriceDesc();
}

package com.example.repository;

import com.example.domain.ProductPack;
import com.example.domain.ProductPackId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface ProductPackRepository extends JpaRepository<ProductPack, ProductPackId> {
}

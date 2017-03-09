package com.example.repository;

import com.example.domain.ProductPackFlavor;
import com.example.domain.ProductPackFlavorId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface ProductPackFlavorRepository extends JpaRepository<ProductPackFlavor, ProductPackFlavorId> {
}

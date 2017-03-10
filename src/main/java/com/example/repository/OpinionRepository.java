package com.example.repository;

import com.example.domain.Opinion;
import com.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adam on 3/8/17.
 */
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
    List<Opinion> findByProduct(Product product);
}

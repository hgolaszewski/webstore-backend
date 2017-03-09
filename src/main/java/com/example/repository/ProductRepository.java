package com.example.repository;

import com.example.domain.Category;
import com.example.domain.Producer;
import com.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adam on 3/8/17.
 */
public interface ProductRepository extends JpaRepository<Product, Short> {
	List<Product> findProductsByName(String name);
	Product findProductByNameAndProducer(String name, Producer producer);
	List<Product> findProductsByCategory(Category category);
	List<Product> findProductsByProducer(Producer producer);
}

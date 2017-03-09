package com.example.service;

import com.example.domain.Category;
import com.example.domain.Producer;
import com.example.domain.Product;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
public interface ProductService {
	public Product addProduct(Product product);

	public Product getProductById(short id);

	public List<Product> listProducts();

	public List<Product> listProductsByName(String name);

	public List<Product> listProductsByCategory(Category category);

	public List<Product> listProductsByProducer(Producer producer);

	public Product updateProduct(Product product);

	public void deleteProduct(Product product);

}

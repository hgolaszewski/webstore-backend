package com.example.service.impl;

import com.example.domain.Category;
import com.example.domain.Producer;
import com.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		Product retProduct = productRepository.findProductByNameAndProducer(
				product.getName(),
				product.getProducer());
		if(retProduct == null){
			retProduct = productRepository.save(product);
		}
		return retProduct;
	}

	@Override
	public Product getProductById(short id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> listProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> listProductsByName(String name) {
		return productRepository.findProductsByName(name);
	}

	@Override
	public List<Product> listProductsByCategory(Category category) {
		return productRepository.findProductsByCategory(category);
	}

	@Override
	public List<Product> listProductsByProducer(Producer producer) {
		return productRepository.findProductsByProducer(producer);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}

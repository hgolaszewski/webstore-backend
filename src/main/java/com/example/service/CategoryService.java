package com.example.service;

import com.example.domain.Category;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
public interface CategoryService {
	public Category addCategory(Category category);

	public List<Category> addCategories(List<Category> categories);

	public Category getCategoryByName(String name);

	public List<Category> listCategories();
	
	public Category updateCategory(Category category);
	
	public void deleteCategory(Category category);

	public void deleteCategory(Short id);
}

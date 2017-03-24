package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		Category retCategory = categoryRepository.findCategoryByName(category.getName());
		if (retCategory == null) {
			retCategory = categoryRepository.save(category);
		}
		return retCategory;
	}

	@Override
	public List<Category> addCategories(List<Category> categories) {
		List<Category> retCategories = new ArrayList<>();
		for (Category category : categories) {
			retCategories.add(addCategory(category));
		}
		return retCategories;
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.findCategoryByName(name);
	}

	@Override
	public List<Category> listCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void deleteCategory(Short id) {
		categoryRepository.delete(id);
	}


}

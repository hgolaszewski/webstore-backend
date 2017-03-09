package com.example.repository;

import com.example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by adam on 3/8/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Short> {
	Category findCategoryByName(@Param("name") String name);
}

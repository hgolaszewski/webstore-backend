package com.example.repository;

import com.example.domain.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface FlavorRepository extends JpaRepository<Flavor, Short> {
	
}

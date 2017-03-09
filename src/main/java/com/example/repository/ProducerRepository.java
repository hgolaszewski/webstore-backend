package com.example.repository;

import com.example.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface ProducerRepository extends JpaRepository<Producer, Short> {
	Producer findProducerByName(String name);
}

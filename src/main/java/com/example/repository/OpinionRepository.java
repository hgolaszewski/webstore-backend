package com.example.repository;

import com.example.domain.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
}

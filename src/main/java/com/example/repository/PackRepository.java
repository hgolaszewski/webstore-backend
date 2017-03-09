package com.example.repository;

import com.example.domain.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/8/17.
 */
public interface PackRepository extends JpaRepository<Pack, Short> {
}

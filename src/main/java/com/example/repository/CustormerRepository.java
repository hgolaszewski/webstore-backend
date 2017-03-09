package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/9/17.
 */
public interface CustormerRepository extends JpaRepository<Customer,Short> {
}

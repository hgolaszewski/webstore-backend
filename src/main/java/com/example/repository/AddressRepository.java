package com.example.repository;

import com.example.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 3/9/17.
 */
public interface AddressRepository extends JpaRepository<Address, Short> {
}

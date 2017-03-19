package com.example.service.impl;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hubertus on 3/16/17.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] result = mDigest.digest(customer.getPassword().getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            customer.setPassword(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return customerRepository.save(customer);
    }

}

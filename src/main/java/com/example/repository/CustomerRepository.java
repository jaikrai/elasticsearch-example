package com.example.repository;


import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    List<Customer> findByFirstName(String firstName);
}

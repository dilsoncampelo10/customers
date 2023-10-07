package com.dilson.customers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilson.customers.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}

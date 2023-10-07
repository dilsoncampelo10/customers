package com.dilson.customers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dilson.customers.models.Customer;
import com.dilson.customers.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        List<Customer> customers = this.customerRepository.findAll();

        return customers;
    }

    public Customer findById(Long id) {
        Optional<Customer> customer = this.customerRepository.findById(id);

        return customer.orElseThrow(() -> new RuntimeException("customer not found"));
    }

    @Transactional
    public Customer create(Customer customer) {
        customer.setId(null);
        customer = this.customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public Customer update(Customer customer) {
        customer = this.customerRepository.save(customer);
        return customer;
    }

    public void delete(Long id) {
        try {
            this.customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Customer not found");
        }
    }

}

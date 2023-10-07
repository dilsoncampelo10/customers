package com.dilson.customers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilson.customers.models.Customer;
import com.dilson.customers.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = this.customerService.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = this.customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer newCustomer = this.customerService.create(customer);
        return ResponseEntity.ok().body(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable Long id) {
        customer.setId(id);
        this.customerService.update(customer);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

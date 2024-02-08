package com.example.Online.Courier.Management.System.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer findById(Long id);
    List<Customer> findAll();
    Customer save(Customer customer);
    void delete(Long id);
}


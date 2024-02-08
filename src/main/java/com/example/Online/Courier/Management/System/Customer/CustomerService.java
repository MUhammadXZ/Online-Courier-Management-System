package com.example.Online.Courier.Management.System.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}


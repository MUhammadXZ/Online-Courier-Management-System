package com.example.Online.Courier.Management.System.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override

    public Customer updateCustomer(Long id, Customer customer) {
        // Retrieve the existing customer by ID
        Customer existingCustomer = customerRepository.findById(id);

        // Check if the customer exists
        if (existingCustomer == null) {
            // Handle the case where the customer with the given ID does not exist
            throw new RuntimeException("Customer not found with id: " + id);
        }

        // Update the existing customer's fields with the new values
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());

        // Save the updated customer
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }
}



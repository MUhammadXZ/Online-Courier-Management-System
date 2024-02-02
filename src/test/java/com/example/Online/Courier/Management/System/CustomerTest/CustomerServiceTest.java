package com.example.Online.Courier.Management.System.CustomerTest;

import com.example.Online.Courier.Management.System.Customer.Customer;
import com.example.Online.Courier.Management.System.Customer.CustomerRepository;
import com.example.Online.Courier.Management.System.Customer.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        // Mock data
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Customer 1");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Customer 2");

        List<Customer> mockCustomers = Arrays.asList(customer1, customer2);

        // Mock repository behavior
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        // Test the service method
        List<Customer> result = customerService.getAllCustomers();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetCustomerById() {
        // Mock data
        Long customerId = 1L;
        Customer mockCustomer = new Customer();
        mockCustomer.setId(customerId);
        mockCustomer.setName("Mock Customer");

        // Mock repository behavior
        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(mockCustomer));

        // Test the service method
        Customer result = customerService.getCustomerById(customerId);

        // Assert the result
        assertEquals("Mock Customer", result.getName());
    }

    @Test
    public void testSaveCustomer() {
        // Mock data
        Customer customerToSave = new Customer();
        customerToSave.setId(1L);
        customerToSave.setName("New Customer");

        // Test the service method
        customerService.saveCustomer(customerToSave);

        // Verify that save method of repository is called
        verify(customerRepository, times(1)).save(customerToSave);
    }

    @Test
    public void testDeleteCustomer() {
        // Mock data
        Long customerId = 1L;

        // Test the service method
        customerService.deleteCustomer(customerId);

        // Verify that deleteById method of repository is called
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    // Add more test methods as needed for other CustomerService functionalities
}


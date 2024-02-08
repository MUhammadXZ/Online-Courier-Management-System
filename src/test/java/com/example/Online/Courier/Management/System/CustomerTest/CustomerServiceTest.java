package com.example.Online.Courier.Management.System.CustomerTest;

import com.example.Online.Courier.Management.System.Customer.Customer;
import com.example.Online.Courier.Management.System.Customer.CustomerRepository;
import com.example.Online.Courier.Management.System.Customer.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateCustomer_Success() {
        // Mock data
        Long customerId = 1L;
        Customer existingCustomer = new Customer();
        existingCustomer.setId(customerId);
        existingCustomer.setName("John Doe");
        existingCustomer.setEmail("john.doe@example.com");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(customerId);
        updatedCustomer.setName("John Smith");
        updatedCustomer.setEmail("john.smith@example.com");

        // Mock repository behavior
        when(customerRepository.findById(customerId)).thenReturn(existingCustomer);
        when(customerRepository.save(existingCustomer)).thenReturn(updatedCustomer);

        // Test the service method
        Customer result = customerService.updateCustomer(customerId, updatedCustomer);

        // Verify the result
        assertEquals(updatedCustomer.getId(), result.getId());
        assertEquals(updatedCustomer.getName(), result.getName());
        assertEquals(updatedCustomer.getEmail(), result.getEmail());
        verify(customerRepository, times(1)).findById(customerId);
        verify(customerRepository, times(1)).save(existingCustomer);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateCustomer_CustomerNotFound() {
        // Mock data
        Long customerId = 1L;
        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(customerId);
        updatedCustomer.setName("John Smith");
        updatedCustomer.setEmail("john.smith@example.com");

        // Mock repository behavior (return null to simulate customer not found)
        when(customerRepository.findById(customerId)).thenReturn(null);

        // Test the service method
        customerService.updateCustomer(customerId, updatedCustomer);
    }
}



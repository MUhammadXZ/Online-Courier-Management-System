package com.example.Online.Courier.Management.System.PaymentTest;

import com.example.Online.Courier.Management.System.Payment.Payment;
import com.example.Online.Courier.Management.System.Payment.PaymentRepository;
import com.example.Online.Courier.Management.System.Payment.PaymentService;
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
public class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testGetAllPayments() {
        // Mock data
        Payment payment1 = new Payment();
        payment1.setId(1L);
        payment1.setAmount(50.0);

        Payment payment2 = new Payment();
        payment2.setId(2L);
        payment2.setAmount(75.0);

        List<Payment> mockPayments = Arrays.asList(payment1, payment2);

        // Mock repository behavior
        when(paymentRepository.findAll()).thenReturn(mockPayments);

        // Test the service method
        List<Payment> result = paymentService.getAllPayments();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetPaymentById() {
        // Mock data
        Long paymentId = 1L;
        Payment mockPayment = new Payment();
        mockPayment.setId(paymentId);
        mockPayment.setAmount(100.0);

        // Mock repository behavior
        when(paymentRepository.findById(paymentId)).thenReturn(java.util.Optional.of(mockPayment));

        // Test the service method
        Payment result = paymentService.getPaymentById(paymentId);

        // Assert the result
        assertEquals(100.0, result.getAmount(), 0.0);
    }

    @Test
    public void testSavePayment() {
        // Mock data
        Payment paymentToSave = new Payment();
        paymentToSave.setId(1L);
        paymentToSave.setAmount(200.0);

        // Test the service method
        paymentService.savePayment(paymentToSave);

        // Verify that save method of repository is called
        verify(paymentRepository, times(1)).save(paymentToSave);
    }

    @Test
    public void testDeletePayment() {
        // Mock data
        Long paymentId = 1L;

        // Test the service method
        paymentService.deletePayment(paymentId);

        // Verify that deleteById method of repository is called
        verify(paymentRepository, times(1)).deleteById(paymentId);
    }


}


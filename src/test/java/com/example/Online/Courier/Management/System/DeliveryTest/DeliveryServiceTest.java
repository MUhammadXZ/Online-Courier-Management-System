package com.example.Online.Courier.Management.System.DeliveryTest;

import com.example.Online.Courier.Management.System.Delivery.Delivery;
import com.example.Online.Courier.Management.System.Delivery.DeliveryRepository;
import com.example.Online.Courier.Management.System.Delivery.DeliveryService;
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
public class DeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @Test
    public void testGetAllDeliveries() {
        // Mock data
        Delivery delivery1 = new Delivery();
        delivery1.setId(1L);
        delivery1.setStatus("Delivered");

        Delivery delivery2 = new Delivery();
        delivery2.setId(2L);
        delivery2.setStatus("In Transit");

        List<Delivery> mockDeliveries = Arrays.asList(delivery1, delivery2);

        // Mock repository behavior
        when(deliveryRepository.findAll()).thenReturn(mockDeliveries);

        // Test the service method
        List<Delivery> result = deliveryService.getAllDeliveries();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDeliveryById() {
        // Mock data
        Long deliveryId = 1L;
        Delivery mockDelivery = new Delivery();
        mockDelivery.setId(deliveryId);
        mockDelivery.setStatus("Mock Delivery");

        // Mock repository behavior
        when(deliveryRepository.findById(deliveryId)).thenReturn(java.util.Optional.of(mockDelivery));

        // Test the service method
        Delivery result = deliveryService.getDeliveryById(deliveryId);

        // Assert the result
        assertEquals("Mock Delivery", result.getStatus());
    }

    @Test
    public void testSaveDelivery() {
        // Mock data
        Delivery deliveryToSave = new Delivery();
        deliveryToSave.setId(1L);
        deliveryToSave.setStatus("New Delivery");

        // Test the service method
        deliveryService.saveDelivery(deliveryToSave);

        // Verify that save method of repository is called
        verify(deliveryRepository, times(1)).save(deliveryToSave);
    }

    @Test
    public void testDeleteDelivery() {
        // Mock data
        Long deliveryId = 1L;

        // Test the service method
        deliveryService.deleteDelivery(deliveryId);

        // Verify that deleteById method of repository is called
        verify(deliveryRepository, times(1)).deleteById(deliveryId);
    }


}


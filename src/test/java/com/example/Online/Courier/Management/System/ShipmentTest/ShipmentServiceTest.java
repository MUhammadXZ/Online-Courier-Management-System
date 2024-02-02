package com.example.Online.Courier.Management.System.ShipmentTest;

import com.example.Online.Courier.Management.System.Shipment.Shipment;
import com.example.Online.Courier.Management.System.Shipment.ShipmentRepository;
import com.example.Online.Courier.Management.System.Shipment.ShipmentService;
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
public class ShipmentServiceTest {
    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentService shipmentService;

    @Test
    public void testGetAllShipments() {
        // Mock data
        Shipment shipment1 = new Shipment();
        shipment1.setId(1L);
        shipment1.setDescription("Shipment 1");
        shipment1.setDestination("Destination 1");

        Shipment shipment2 = new Shipment();
        shipment2.setId(2L);
        shipment2.setDescription("Shipment 2");
        shipment2.setDestination("Destination 2");

        List<Shipment> mockShipments = Arrays.asList(shipment1, shipment2);

        // Mock repository behavior
        when(shipmentRepository.findAll()).thenReturn(mockShipments);

        // Test the service method
        List<Shipment> result = shipmentService.getAllShipments();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetShipmentById() {
        // Mock data
        Long shipmentId = 1L;
        Shipment mockShipment = new Shipment();
        mockShipment.setId(shipmentId);
        mockShipment.setDescription("Mock Shipment");
        mockShipment.setDestination("Mock Destination");

        // Mock repository behavior
        when(shipmentRepository.findById(shipmentId)).thenReturn(java.util.Optional.of(mockShipment));

        // Test the service method
        Shipment result = shipmentService.getShipmentById(shipmentId);

        // Assert the result
        assertEquals("Mock Shipment", result.getDescription());
        assertEquals("Mock Destination", result.getDestination());
    }

    @Test
    public void testSaveShipment() {
        // Mock data
        Shipment shipmentToSave = new Shipment();
        shipmentToSave.setId(1L);
        shipmentToSave.setDescription("New Shipment");
        shipmentToSave.setDestination("New Destination");

        // Test the service method
        shipmentService.saveShipment(shipmentToSave);

        // Verify that save method of repository is called
        verify(shipmentRepository, times(1)).save(shipmentToSave);
    }

    @Test
    public void testDeleteShipment() {
        // Mock data
        Long shipmentId = 1L;

        // Test the service method
        shipmentService.deleteShipment(shipmentId);

        // Verify that deleteById method of repository is called
        verify(shipmentRepository, times(1)).deleteById(shipmentId);
    }


}


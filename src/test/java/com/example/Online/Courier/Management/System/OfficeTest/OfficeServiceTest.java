package com.example.Online.Courier.Management.System.OfficeTest;

import com.example.Online.Courier.Management.System.Office.Office;
import com.example.Online.Courier.Management.System.Office.OfficeRepository;
import com.example.Online.Courier.Management.System.Office.OfficeService;
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
public class OfficeServiceTest {
    @Mock
    private OfficeRepository officeRepository;

    @InjectMocks
    private OfficeService officeService;

    @Test
    public void testGetAllOffices() {
        // Mock data
        Office office1 = new Office();
        office1.setId(1L);
        office1.setName("Office 1");

        Office office2 = new Office();
        office2.setId(2L);
        office2.setName("Office 2");

        List<Office> mockOffices = Arrays.asList(office1, office2);

        // Mock repository behavior
        when(officeRepository.findAll()).thenReturn(mockOffices);

        // Test the service method
        List<Office> result = officeService.getAllOffices();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetOfficeById() {
        // Mock data
        Long officeId = 1L;
        Office mockOffice = new Office();
        mockOffice.setId(officeId);
        mockOffice.setName("Mock Office");

        // Mock repository behavior
        when(officeRepository.findById(officeId)).thenReturn(java.util.Optional.of(mockOffice));

        // Test the service method
        Office result = officeService.getOfficeById(officeId);

        // Assert the result
        assertEquals("Mock Office", result.getName());
    }

    @Test
    public void testSaveOffice() {
        // Mock data
        Office officeToSave = new Office();
        officeToSave.setId(1L);
        officeToSave.setName("New Office");

        // Test the service method
        officeService.saveOffice(officeToSave);

        // Verify that save method of repository is called
        verify(officeRepository, times(1)).save(officeToSave);
    }

    @Test
    public void testDeleteOffice() {
        // Mock data
        Long officeId = 1L;

        // Test the service method
        officeService.deleteOffice(officeId);

        // Verify that deleteById method of repository is called
        verify(officeRepository, times(1)).deleteById(officeId);
    }


}



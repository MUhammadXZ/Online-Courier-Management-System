package com.example.Online.Courier.Management.System.ManagerTest;

import com.example.Online.Courier.Management.System.Manager.Manager;
import com.example.Online.Courier.Management.System.Manager.ManagerRepository;
import com.example.Online.Courier.Management.System.Manager.ManagerService;
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
public class ManagerServiceTest {
    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerService managerService;

    @Test
    public void testGetAllManagers() {
        // Mock data
        Manager manager1 = new Manager();
        manager1.setId(1L);
        manager1.setName("Manager 1");

        Manager manager2 = new Manager();
        manager2.setId(2L);
        manager2.setName("Manager 2");

        List<Manager> mockManagers = Arrays.asList(manager1, manager2);

        // Mock repository behavior
        when(managerRepository.findAll()).thenReturn(mockManagers);

        // Test the service method
        List<Manager> result = managerService.getAllManagers();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetManagerById() {
        // Mock data
        Long managerId = 1L;
        Manager mockManager = new Manager();
        mockManager.setId(managerId);
        mockManager.setName("Mock Manager");

        // Mock repository behavior
        when(managerRepository.findById(managerId)).thenReturn(java.util.Optional.of(mockManager));

        // Test the service method
        Manager result = managerService.getManagerById(managerId);

        // Assert the result
        assertEquals("Mock Manager", result.getName());
    }

    @Test
    public void testSaveManager() {
        // Mock data
        Manager managerToSave = new Manager();
        managerToSave.setId(1L);
        managerToSave.setName("New Manager");

        // Test the service method
        managerService.saveManager(managerToSave);

        // Verify that save method of repository is called
        verify(managerRepository, times(1)).save(managerToSave);
    }

    @Test
    public void testDeleteManager() {
        // Mock data
        Long managerId = 1L;

        // Test the service method
        managerService.deleteManager(managerId);

        // Verify that deleteById method of repository is called
        verify(managerRepository, times(1)).deleteById(managerId);
    }


}


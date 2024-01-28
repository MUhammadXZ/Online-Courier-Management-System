package com.example.Online.Courier.Management.System.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// OfficeService.java
@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    public void saveOffice(Office office) {
        officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}


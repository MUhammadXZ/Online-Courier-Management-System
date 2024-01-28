package com.example.Online.Courier.Management.System.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @GetMapping
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable Long id) {
        Office office = officeService.getOfficeById(id);
        return office != null ? ResponseEntity.ok(office) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveOffice(@RequestBody Office office) {
        officeService.saveOffice(office);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.Online.Courier.Management.System.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Manager manager = managerService.getManagerById(id);
        return manager != null ? ResponseEntity.ok(manager) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveManager(@RequestBody Manager manager) {
        managerService.saveManager(manager);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.Online.Courier.Management.System.Office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// OfficeRepository.java
@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    // Additional methods if needed
}


package com.hostelmanagementsystem.repository;

import com.hostelmanagementsystem.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
    // Custom query methods can be added here if needed
}
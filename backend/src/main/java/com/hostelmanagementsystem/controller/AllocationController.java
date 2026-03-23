package com.hostelmanagementsystem.controller;

import com.hostelmanagementsystem.model.Allocation;
import com.hostelmanagementsystem.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @GetMapping
    public ResponseEntity<List<Allocation>> getAllAllocations() {
        List<Allocation> allocations = allocationService.getAllAllocations();
        return ResponseEntity.ok(allocations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Allocation> getAllocationById(@PathVariable Long id) {
        Optional<Allocation> allocation = allocationService.getAllocationById(id);
        if (allocation.isPresent()) {
            return ResponseEntity.ok(allocation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation allocation) {
        Allocation createdAllocation = allocationService.createAllocation(allocation);
        return ResponseEntity.status(201).body(createdAllocation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Allocation> updateAllocation(@PathVariable Long id, @RequestBody Allocation updatedAllocation) {
        Optional<Allocation> existingAllocation = allocationService.getAllocationById(id);
        if (existingAllocation.isPresent()) {
            updatedAllocation.setId(id);
            Allocation savedAllocation = allocationService.createAllocation(updatedAllocation);
            return ResponseEntity.ok(savedAllocation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllocation(@PathVariable Long id) {
        Optional<Allocation> existingAllocation = allocationService.getAllocationById(id);
        if (existingAllocation.isPresent()) {
            // Assuming AllocationRepository has a method to delete by ID
            allocationService.deleteAllocation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
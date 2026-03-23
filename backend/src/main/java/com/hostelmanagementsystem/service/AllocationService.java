package com.hostelmanagementsystem.service;

import com.hostelmanagementsystem.model.Allocation;
import com.hostelmanagementsystem.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        return allocationRepository.findById(id);
    }

    public Allocation createAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    public Allocation updateAllocation(Long id, Allocation updatedAllocation) {
        if (allocationRepository.existsById(id)) {
            updatedAllocation.setId(id);
            return allocationRepository.save(updatedAllocation);
        }
        throw new RuntimeException("Allocation not found");
    }

    public void deleteAllocation(Long id) {
        if (allocationRepository.existsById(id)) {
            allocationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Allocation not found");
        }
    }
}
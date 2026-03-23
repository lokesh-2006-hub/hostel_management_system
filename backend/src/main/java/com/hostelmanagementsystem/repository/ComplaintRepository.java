package com.hostelmanagementsystem.repository;

import com.hostelmanagementsystem.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Custom query methods can be added here if needed
}
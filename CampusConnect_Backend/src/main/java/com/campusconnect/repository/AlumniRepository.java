package com.campusconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.User;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    // Find alumni by User
    Optional<Alumni> findByUser(User user);

    // Search by Company
    List<Alumni> findByCompanyNameContainingIgnoreCase(String companyName);

    // Search by Designation
    List<Alumni> findByDesignationContainingIgnoreCase(String designation);

    // Search by Expertise/Skills
    List<Alumni> findByExpertiseContainingIgnoreCase(String expertise);
    Optional<Alumni> findByUser(User user);

}
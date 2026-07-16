package com.campusconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.User;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    Optional<Alumni> findByUser(User user);

    List<Alumni> findByCompanyNameContainingIgnoreCase(String companyName);

    List<Alumni> findByDesignationContainingIgnoreCase(String designation);

    List<Alumni> findByExpertiseContainingIgnoreCase(String expertise);

}
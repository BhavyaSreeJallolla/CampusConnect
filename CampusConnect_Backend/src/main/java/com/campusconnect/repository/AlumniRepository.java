package com.campusconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.User;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    List<Alumni> findByCompanyName(String companyName);

    List<Alumni> findByExpertiseContainingIgnoreCase(String expertise);
    Optional<Alumni> findByUser(User user);

}
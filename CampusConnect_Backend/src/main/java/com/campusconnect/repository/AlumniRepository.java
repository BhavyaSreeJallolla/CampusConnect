package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusconnect.entity.Alumni;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    List<Alumni> findByCompanyName(String companyName);

    List<Alumni> findByExpertiseContainingIgnoreCase(String expertise);

}
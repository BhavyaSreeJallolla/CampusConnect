package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.User;

public interface AlumniService {

    // Create Alumni Profile
    Alumni saveAlumni(Alumni alumni);

    // Update Alumni Profile
    Alumni updateAlumni(Long alumniId, Alumni alumni);

    // Get Alumni by ID
    Alumni getAlumniById(Long alumniId);

    // Get All Alumni
    List<Alumni> getAllAlumni();

    // Delete Alumni
    void deleteAlumni(Long alumniId);

    // Search Alumni by Company
    List<Alumni> searchByCompany(String companyName);

    // Search Alumni by Expertise
    List<Alumni> searchByExpertise(String expertise);

    // Search Alumni by Designation
    List<Alumni> searchByDesignation(String designation);

    // Get Alumni by User
    Alumni getAlumniByUser(User user);
}

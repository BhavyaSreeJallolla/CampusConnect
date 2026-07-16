package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Alumni;

public interface AlumniService {

    // Create Alumni Profile
    Alumni saveAlumni(Alumni alumni);

    // Alumni updates own profile
    Alumni updateMyProfile(String email, Alumni alumni);

    // Admin updates any alumni
    Alumni updateAlumni(Long alumniId, Alumni alumni);

    // Get Alumni By Id
    Alumni getAlumniById(Long alumniId);

    // Get All Alumni
    List<Alumni> getAllAlumni();

    // Delete Alumni
    void deleteAlumni(Long alumniId);

    // Search Alumni
    List<Alumni> searchByExpertise(String expertise);
    void deleteMyProfile(String email);

}
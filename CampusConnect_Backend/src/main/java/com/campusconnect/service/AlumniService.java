package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Alumni;

public interface AlumniService {

    Alumni saveAlumni(Alumni alumni);

    Alumni updateAlumni(Long alumniId, Alumni alumni);

    Alumni getAlumniById(Long alumniId);

    List<Alumni> getAllAlumni();

    void deleteAlumni(Long alumniId);

    List<Alumni> searchByExpertise(String expertise);

}
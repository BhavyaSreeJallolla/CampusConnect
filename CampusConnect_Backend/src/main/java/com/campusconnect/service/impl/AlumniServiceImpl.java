package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.User;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.UserRepository;
import com.campusconnect.service.AlumniService;

@Service
public class AlumniServiceImpl implements AlumniService {

    @Autowired
    private AlumniRepository alumniRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Alumni saveAlumni(Alumni alumni) {

        User user = userRepository.findById(alumni.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        alumni.setUser(user);

        return alumniRepository.save(alumni);
    }

    @Override
    public Alumni updateAlumni(Long alumniId, Alumni alumni) {

        Alumni existingAlumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found"));

        existingAlumni.setCollegeName(alumni.getCollegeName());
        existingAlumni.setGraduationYear(alumni.getGraduationYear());
        existingAlumni.setCompanyName(alumni.getCompanyName());
        existingAlumni.setDesignation(alumni.getDesignation());
        existingAlumni.setExperience(alumni.getExperience());
        existingAlumni.setPhone(alumni.getPhone());
        existingAlumni.setBio(alumni.getBio());
        existingAlumni.setExpertise(alumni.getExpertise());
        existingAlumni.setLinkedinUrl(alumni.getLinkedinUrl());
        existingAlumni.setProfileImage(alumni.getProfileImage());
        existingAlumni.setCompanyIdCard(alumni.getCompanyIdCard());

        return alumniRepository.save(existingAlumni);
    }

    @Override
    public Alumni getAlumniById(Long alumniId) {
        return alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found"));
    }

    @Override
    public List<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    @Override
    public void deleteAlumni(Long alumniId) {

        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found"));

        alumniRepository.delete(alumni);
    }

    @Override
    public List<Alumni> searchByCompany(String companyName) {
        return alumniRepository.findByCompanyNameContainingIgnoreCase(companyName);
    }

    @Override
    public List<Alumni> searchByDesignation(String designation) {
        return alumniRepository.findByDesignationContainingIgnoreCase(designation);
    }

    @Override
    public List<Alumni> searchByExpertise(String expertise) {
        return alumniRepository.findByExpertiseContainingIgnoreCase(expertise);
    }

    @Override
    public Alumni getAlumniByUser(User user) {
        return alumniRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Alumni not found"));
    }
}
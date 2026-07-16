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

        if (alumni.getCollegeName() != null)
            existingAlumni.setCollegeName(alumni.getCollegeName());

        if (alumni.getGraduationYear() != null)
            existingAlumni.setGraduationYear(alumni.getGraduationYear());

        if (alumni.getCompanyName() != null)
            existingAlumni.setCompanyName(alumni.getCompanyName());

        if (alumni.getDesignation() != null)
            existingAlumni.setDesignation(alumni.getDesignation());

        if (alumni.getExperience() != null)
            existingAlumni.setExperience(alumni.getExperience());

        if (alumni.getPhone() != null)
            existingAlumni.setPhone(alumni.getPhone());

        if (alumni.getBio() != null)
            existingAlumni.setBio(alumni.getBio());

        if (alumni.getExpertise() != null)
            existingAlumni.setExpertise(alumni.getExpertise());

        if (alumni.getLinkedinUrl() != null)
            existingAlumni.setLinkedinUrl(alumni.getLinkedinUrl());

        if (alumni.getProfileImage() != null)
            existingAlumni.setProfileImage(alumni.getProfileImage());

        if (alumni.getCompanyIdCard() != null)
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
    public List<Alumni> searchByExpertise(String expertise) {
        return alumniRepository.findByExpertiseContainingIgnoreCase(expertise);
    }

    @Override
    public Alumni updateMyProfile(String email, Alumni alumni) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Alumni existingAlumni = alumniRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Alumni profile not found"));

        if (alumni.getCollegeName() != null)
            existingAlumni.setCollegeName(alumni.getCollegeName());

        if (alumni.getGraduationYear() != null)
            existingAlumni.setGraduationYear(alumni.getGraduationYear());

        if (alumni.getCompanyName() != null)
            existingAlumni.setCompanyName(alumni.getCompanyName());

        if (alumni.getDesignation() != null)
            existingAlumni.setDesignation(alumni.getDesignation());

        if (alumni.getExperience() != null)
            existingAlumni.setExperience(alumni.getExperience());

        if (alumni.getPhone() != null)
            existingAlumni.setPhone(alumni.getPhone());

        if (alumni.getBio() != null)
            existingAlumni.setBio(alumni.getBio());

        if (alumni.getExpertise() != null)
            existingAlumni.setExpertise(alumni.getExpertise());

        if (alumni.getLinkedinUrl() != null)
            existingAlumni.setLinkedinUrl(alumni.getLinkedinUrl());

        if (alumni.getProfileImage() != null)
            existingAlumni.setProfileImage(alumni.getProfileImage());

        if (alumni.getCompanyIdCard() != null)
            existingAlumni.setCompanyIdCard(alumni.getCompanyIdCard());

        return alumniRepository.save(existingAlumni);
    }
    @Override
    public void deleteMyProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Alumni alumni = alumniRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Alumni profile not found"));

        alumniRepository.delete(alumni);

        userRepository.delete(user);
    }
}
package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Guidance;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.GuidanceRepository;
import com.campusconnect.service.GuidanceService;

@Service
public class GuidanceServiceImpl implements GuidanceService {

    @Autowired
    private GuidanceRepository guidanceRepository;

    @Autowired
    private AlumniRepository alumniRepository;

    @Override
    public Guidance saveGuidance(Guidance guidance) {

        Alumni alumni = alumniRepository.findById(
                guidance.getAlumni().getAlumniId())
                .orElseThrow(() -> new RuntimeException("Alumni not found"));

        guidance.setAlumni(alumni);

        return guidanceRepository.save(guidance);
    }

    @Override
    public List<Guidance> getGuidanceByAlumni(Long alumniId) {

        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found"));

        return guidanceRepository.findByAlumni(alumni);
    }
}
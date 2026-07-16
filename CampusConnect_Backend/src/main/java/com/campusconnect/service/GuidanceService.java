package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Guidance;

public interface GuidanceService {

    // Save Guidance
    Guidance saveGuidance(Guidance guidance);

    // View Guidance by Alumni
    List<Guidance> getGuidanceByAlumni(Long alumniId);

}
package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Guidance;
import com.campusconnect.service.GuidanceService;

@RestController
@RequestMapping("/api/guidance")
@CrossOrigin("*")
public class GuidanceController {

    @Autowired
    private GuidanceService guidanceService;

    // Add Guidance
    @PostMapping
    public Guidance saveGuidance(@RequestBody Guidance guidance) {
        return guidanceService.saveGuidance(guidance);
    }

    // Get Guidance by Alumni ID
    @GetMapping("/alumni/{alumniId}")
    public List<Guidance> getGuidanceByAlumni(
            @PathVariable Long alumniId) {

        return guidanceService.getGuidanceByAlumni(alumniId);
    }
}
package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Alumni;
import com.campusconnect.service.AlumniService;

@RestController
@RequestMapping("/api/alumni")
@CrossOrigin("*")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    // Create Alumni
    @PostMapping
    public Alumni saveAlumni(@RequestBody Alumni alumni) {
        return alumniService.saveAlumni(alumni);
    }

    // Get Alumni By Id
    @GetMapping("/{alumniId}")
    public Alumni getAlumniById(@PathVariable Long alumniId) {
        return alumniService.getAlumniById(alumniId);
    }

    // Get All Alumni
    @GetMapping
    public List<Alumni> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    // Search Alumni By Expertise
    @GetMapping("/search")
    public List<Alumni> searchByExpertise(@RequestParam String expertise) {
        return alumniService.searchByExpertise(expertise);
    }

    // Update Alumni
    @PutMapping("/{alumniId}")
    public Alumni updateAlumni(@PathVariable Long alumniId,
                               @RequestBody Alumni alumni) {
        return alumniService.updateAlumni(alumniId, alumni);
    }

    // Delete Alumni
    @DeleteMapping("/{alumniId}")
    public String deleteAlumni(@PathVariable Long alumniId) {
        alumniService.deleteAlumni(alumniId);
        return "Alumni deleted successfully.";
    }
}
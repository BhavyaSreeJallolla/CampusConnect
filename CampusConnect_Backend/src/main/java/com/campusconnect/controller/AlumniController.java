package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Alumni;
import com.campusconnect.service.AlumniService;

@RestController
@RequestMapping("/api/alumni")
@CrossOrigin("*")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    // Alumni creates own profile
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

    // Alumni updates own profile
    @PutMapping("/profile")
    public Alumni updateMyProfile(@RequestBody Alumni alumni,
                                  Authentication authentication) {

        return alumniService.updateMyProfile(
                authentication.getName(),
                alumni);
    }
    @DeleteMapping("/profile")
    public String deleteMyProfile(Authentication authentication) {

        alumniService.deleteMyProfile(authentication.getName());

        return "Alumni account deleted successfully.";
    }
}
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



    }


    // Search By Company
    @GetMapping("/search/company")
    public List<Alumni> searchByCompany(
            @RequestParam String companyName) {

        return alumniService.searchByCompany(companyName);
    }

    // Search By Designation
    @GetMapping("/search/designation")
    public List<Alumni> searchByDesignation(
            @RequestParam String designation) {

        return alumniService.searchByDesignation(designation);
    }

    // Search By Expertise
    @GetMapping("/search/expertise")
    public List<Alumni> searchByExpertise(
            @RequestParam String expertise) {

        return alumniService.searchByExpertise(expertise);
    }
}
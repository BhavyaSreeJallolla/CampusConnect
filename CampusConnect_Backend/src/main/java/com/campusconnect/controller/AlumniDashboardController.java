package com.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.AlumniDashboardDTO;
import com.campusconnect.service.AlumniDashboardService;


@RestController
@RequestMapping("/api/alumni/dashboard")
@CrossOrigin("*")
public class AlumniDashboardController {


    @Autowired
    private AlumniDashboardService dashboardService;


    @GetMapping("/{alumniId}")
    public AlumniDashboardDTO getDashboard(
            @PathVariable Long alumniId) {

        return dashboardService.getDashboard(alumniId);
    }
}
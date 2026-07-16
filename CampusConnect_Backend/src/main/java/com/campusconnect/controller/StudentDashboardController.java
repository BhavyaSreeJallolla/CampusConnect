package com.campusconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.StudentDashboardDTO;
import com.campusconnect.service.StudentDashboardService;


@RestController
@RequestMapping("/api/student/dashboard")
@CrossOrigin("*")
public class StudentDashboardController {


    @Autowired
    private StudentDashboardService dashboardService;



    @GetMapping("/{studentId}")
    public StudentDashboardDTO getDashboard(
            @PathVariable Long studentId) {


        return dashboardService.getDashboard(studentId);

    }

}
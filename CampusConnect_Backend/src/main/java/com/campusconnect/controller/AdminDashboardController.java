package com.campusconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.AdminDashboardDTO;
import com.campusconnect.service.AdminDashboardService;


@RestController
@RequestMapping("/api/admin/dashboard")
@CrossOrigin("*")
public class AdminDashboardController {


    @Autowired
    private AdminDashboardService dashboardService;



    @GetMapping
    public AdminDashboardDTO getDashboard(){

        return dashboardService.getDashboard();

    }

}
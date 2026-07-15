package com.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.StatusUpdateRequest;
import com.campusconnect.entity.User;
import com.campusconnect.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PutMapping("/users/{userId}/status")
    public User updateStatus(@PathVariable Long userId,
                             @RequestBody StatusUpdateRequest request) {

        return adminService.updateStatus(userId, request.getStatus());
    }
}
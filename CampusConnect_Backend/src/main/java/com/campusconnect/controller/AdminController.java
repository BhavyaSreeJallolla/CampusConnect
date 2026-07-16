package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.StatusUpdateRequest;
import com.campusconnect.dto.UserRequestDTO;
import com.campusconnect.entity.User;
import com.campusconnect.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/test")
    public String test(Authentication auth) {
        return auth.getAuthorities().toString();
    }

    @PutMapping("/users/{userId}/status")
    public User updateStatus(@PathVariable Long userId,
                             @RequestBody StatusUpdateRequest request) {

        return adminService.updateStatus(userId, request.getStatus());
    }

    // Get Pending User Requests
    @GetMapping("/requests")
    public List<UserRequestDTO> getPendingUsers() {

        return adminService.getPendingUsers();

    }
}
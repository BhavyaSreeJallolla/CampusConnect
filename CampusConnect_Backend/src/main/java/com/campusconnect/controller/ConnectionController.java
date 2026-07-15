package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Connection;
import com.campusconnect.service.ConnectionService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/request/{alumniId}")
    public Connection sendRequest(
            @PathVariable Long alumniId,
            @RequestParam Long studentId,
            @RequestParam String message) {

        return connectionService.sendRequest(
                studentId,
                alumniId,
                message);
    }

    @GetMapping("/student/{id}")
    public List<Connection> getStudentConnections(
            @PathVariable Long id) {

        return connectionService.getStudentConnections(id);
    }

    @GetMapping("/alumni/{id}")
    public List<Connection> getAlumniConnections(
            @PathVariable Long id) {

        return connectionService.getAlumniConnections(id);
    }

    @PutMapping("/{id}/accept")
    public Connection acceptRequest(
            @PathVariable Long id) {

        return connectionService.acceptRequest(id);
    }

    @PutMapping("/{id}/reject")
    public Connection rejectRequest(
            @PathVariable Long id) {

        return connectionService.rejectRequest(id);
    }
}
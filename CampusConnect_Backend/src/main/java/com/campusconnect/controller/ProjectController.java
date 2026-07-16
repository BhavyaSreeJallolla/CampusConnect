package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Project;
import com.campusconnect.entity.ProjectRequest;
import com.campusconnect.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create Project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // Search Projects
    @GetMapping("/search")
    public List<Project> searchProjects(@RequestParam String domain) {
        return projectService.searchProjects(domain);
    }

    // Get All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // Get Project By Id
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    // Update Project
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id,
                                 @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    // Delete Project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    // Join Project
    @PostMapping("/{id}/join")
    public ProjectRequest joinProject(@PathVariable Long id,
                                      @RequestParam Long studentId) {
        return projectService.joinProject(id, studentId);
    }

    // Get Project Requests
    @GetMapping("/{id}/requests")
    public List<ProjectRequest> getProjectRequests(@PathVariable Long id) {
        return projectService.getProjectRequests(id);
    }

    // Accept Request
    @PutMapping("/request/{id}/accept")
    public ProjectRequest acceptRequest(@PathVariable Long id) {
        return projectService.acceptRequest(id);
    }

    // Reject Request
    @PutMapping("/request/{id}/reject")
    public ProjectRequest rejectRequest(@PathVariable Long id) {
        return projectService.rejectRequest(id);
    }
}
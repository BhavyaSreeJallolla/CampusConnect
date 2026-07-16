package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Project;
import com.campusconnect.entity.ProjectRequest;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> searchProjects(String domain);

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);

    ProjectRequest joinProject(Long projectId, Long studentId);

    List<ProjectRequest> getProjectRequests(Long projectId);

    ProjectRequest acceptRequest(Long requestId);

    ProjectRequest rejectRequest(Long requestId);

}
package com.campusconnect.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Project;
import com.campusconnect.entity.ProjectRequest;
import com.campusconnect.enums.RequestStatus;
import com.campusconnect.repository.ProjectRepository;
import com.campusconnect.repository.ProjectRequestRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectRequestRepository projectRequestRepository;
    public Project createProject(Project project) {

        project.setCreatedDate(LocalDateTime.now());

        return projectRepository.save(project);

    }
    public List<Project> searchProjects(String domain) {

        return projectRepository.findByDomainContainingIgnoreCase(domain);

    }
    public List<Project> getAllProjects() {

        return projectRepository.findAll();

    }
    public Project getProjectById(Long id) {

        return projectRepository.findById(id).orElse(null);

    }
    public Project updateProject(Long id, Project project) {

        Project existingProject = projectRepository.findById(id).orElse(null);

        if (existingProject != null) {

            existingProject.setProjectName(project.getProjectName());
            existingProject.setDomain(project.getDomain());
            existingProject.setDescription(project.getDescription());
            existingProject.setSkillsRequired(project.getSkillsRequired());
            existingProject.setTeamSize(project.getTeamSize());
            existingProject.setDeadline(project.getDeadline());

            return projectRepository.save(existingProject);
        }

        return null;
    }
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

    }
    public ProjectRequest joinProject(Long projectId, Long studentId) {

        ProjectRequest request = new ProjectRequest();

        request.setProjectId(projectId);
        request.setStudentId(studentId);
        request.setStatus(RequestStatus.PENDING);
        request.setCreatedDate(LocalDateTime.now());

        return projectRequestRepository.save(request);
    }
    public List<ProjectRequest> getProjectRequests(Long projectId) {

        return projectRequestRepository.findByProjectId(projectId);

    }
    public ProjectRequest acceptRequest(Long requestId) {

        ProjectRequest request = projectRequestRepository.findById(requestId).orElse(null);

        if (request != null) {
            request.setStatus(RequestStatus.ACCEPTED);
            return projectRequestRepository.save(request);
        }

        return null;
    }
    public ProjectRequest rejectRequest(Long requestId) {

        ProjectRequest request = projectRequestRepository.findById(requestId).orElse(null);

        if (request != null) {
            request.setStatus(RequestStatus.REJECTED);
            return projectRequestRepository.save(request);
        }

        return null;
    }
}
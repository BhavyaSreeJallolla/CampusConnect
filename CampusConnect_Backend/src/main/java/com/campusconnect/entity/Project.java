package com.campusconnect.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    private String domain;

    @Column(length = 1000)
    private String description;

    @Column(name = "skills_required")
    private String skillsRequired;

    @Column(name = "team_size")
    private Integer teamSize;

    private LocalDate deadline;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Project() {
    }

    public Project(Long id, Long studentId, String projectName, String domain,
                   String description, String skillsRequired,
                   Integer teamSize, LocalDate deadline,
                   LocalDateTime createdDate) {

        this.id = id;
        this.studentId = studentId;
        this.projectName = projectName;
        this.domain = domain;
        this.description = description;
        this.skillsRequired = skillsRequired;
        this.teamSize = teamSize;
        this.deadline = deadline;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
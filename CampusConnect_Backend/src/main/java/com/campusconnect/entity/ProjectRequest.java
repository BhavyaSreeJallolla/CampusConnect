package com.campusconnect.entity;

import java.time.LocalDateTime;

import com.campusconnect.enums.RequestStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "project_requests")
public class ProjectRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public ProjectRequest() {
    }

    public ProjectRequest(Long id, Long projectId, Long studentId,
                          RequestStatus status, LocalDateTime createdDate) {
        this.id = id;
        this.projectId = projectId;
        this.studentId = studentId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
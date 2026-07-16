package com.campusconnect.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "guidance")
public class Guidance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(length = 1000)
    private String guidanceMessage;

    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    public Guidance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(Alumni alumni) {
        this.alumni = alumni;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGuidanceMessage() {
        return guidanceMessage;
    }

    public void setGuidanceMessage(String guidanceMessage) {
        this.guidanceMessage = guidanceMessage;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
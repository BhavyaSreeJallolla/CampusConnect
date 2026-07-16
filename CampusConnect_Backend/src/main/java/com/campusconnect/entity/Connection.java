package com.campusconnect.entity;

import java.time.LocalDateTime;

import com.campusconnect.enums.ConnectionStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "student_id", nullable = false)
    private Long studentId;


    @Column(name = "alumni_id", nullable = false)
    private Long alumniId;


    @Enumerated(EnumType.STRING)
    private ConnectionStatus status;


    @Column(name = "created_date")
    private LocalDateTime createdDate;



    public Connection() {
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



    public Long getAlumniId() {
        return alumniId;
    }


    public void setAlumniId(Long alumniId) {
        this.alumniId = alumniId;
    }



    public ConnectionStatus getStatus() {
        return status;
    }


    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }



    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
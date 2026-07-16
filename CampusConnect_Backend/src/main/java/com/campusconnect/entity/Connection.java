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



    @Enumerated(EnumType.STRING)
    private ConnectionStatus status;


}
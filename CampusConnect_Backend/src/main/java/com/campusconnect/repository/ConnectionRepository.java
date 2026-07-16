package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Connection;
import com.campusconnect.enums.ConnectionStatus;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    // Student all connections
    List<Connection> findByStudentId(Long studentId);

    // Student accepted connections
    List<Connection> findByStudentIdAndStatus(
            Long studentId,
            ConnectionStatus status
    );

    // Alumni all connections
    @Query("SELECT c FROM Connection c WHERE c.alumniId = :alumniId")
    List<Connection> findByAlumniId(Long alumniId);

    // Alumni accepted connections
    List<Connection> findByAlumniIdAndStatus(
            Long alumniId,
            ConnectionStatus status
    );

    // Count connections
    int countByStudentId(Long studentId);

    int countByAlumniId(Long alumniId);

    // Check whether student and alumni have an accepted connection
    boolean existsByStudentIdAndAlumniIdAndStatus(
            Long studentId,
            Long alumniId,
            ConnectionStatus status
    );
}
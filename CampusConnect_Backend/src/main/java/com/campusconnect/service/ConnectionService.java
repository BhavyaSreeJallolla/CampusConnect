package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Connection;

public interface ConnectionService {

    Connection sendRequest(
            Long studentId,
            Long alumniId,
            String message);

    List<Connection> getStudentConnections(Long studentId);

    List<Connection> getAlumniConnections(Long alumniId);

    Connection acceptRequest(Long id);

    Connection rejectRequest(Long id);
}
package com.campusconnect.service;


import java.util.List;

import com.campusconnect.dto.ConnectedAlumniDTO;
import com.campusconnect.dto.ConnectedStudentDTO;
import com.campusconnect.entity.Connection;



public interface ConnectionService {



    // Send connection request
    Connection sendRequest(Connection connection);



    // Get all connections
    List<Connection> getAllConnections();



    // Student view connected alumni
    List<ConnectedAlumniDTO> getStudentConnections(
            Long studentId
    );



    // Alumni view connected students
    List<ConnectedStudentDTO> getAlumniConnections(
            Long alumniId
    );



    // Accept request
    Connection acceptRequest(Long id);



    // Reject request
    Connection rejectRequest(Long id);



    // Delete connection
    void deleteConnection(Long id);

}
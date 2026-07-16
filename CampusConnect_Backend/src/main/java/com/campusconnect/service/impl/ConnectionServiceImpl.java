package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Connection;
import com.campusconnect.entity.Student;
import com.campusconnect.enums.ConnectionStatus;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.ConnectionRepository;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.service.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AlumniRepository alumniRepository;

    @Override
    public Connection sendRequest(Long studentId,
                                  Long alumniId,
                                  String message) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() ->
                        new RuntimeException("Alumni not found"));

        Connection connection = new Connection();

        connection.setStudent(student);
        connection.setAlumni(alumni);
        connection.setMessage(message);
        connection.setStatus(ConnectionStatus.PENDING);

        return connectionRepository.save(connection);
    }

    @Override
    public List<Connection> getStudentConnections(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        return connectionRepository.findByStudent(student);
    }

    @Override
    public List<Connection> getAlumniConnections(Long alumniId) {

        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() ->
                        new RuntimeException("Alumni not found"));

        return connectionRepository.findByAlumni(alumni);
    }

    @Override
    public Connection acceptRequest(Long id) {

        Connection connection = connectionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Connection not found"));

        connection.setStatus(ConnectionStatus.ACCEPTED);

        return connectionRepository.save(connection);
    }

    @Override
    public Connection rejectRequest(Long id) {

        Connection connection = connectionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Connection not found"));

        connection.setStatus(ConnectionStatus.REJECTED);

        return connectionRepository.save(connection);
    }
}
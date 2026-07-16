package com.campusconnect.service.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusconnect.dto.ConnectedAlumniDTO;
import com.campusconnect.dto.ConnectedStudentDTO;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Connection;
import com.campusconnect.entity.Student;

import com.campusconnect.enums.ConnectionStatus;

import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.ConnectionRepository;
import com.campusconnect.repository.StudentRepository;

import com.campusconnect.service.ConnectionService;



@Service
public class ConnectionServiceImpl 
        implements ConnectionService {


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




    // SEND REQUEST
    @Override
    public Connection sendRequest(Connection connection) {


        connection.setStatus(
                ConnectionStatus.PENDING
        );


        connection.setCreatedDate(
                LocalDateTime.now()
        );


        return connectionRepository.save(connection);

    }





    // ALL CONNECTIONS
    @Override
    public List<Connection> getAllConnections() {


        return connectionRepository.findAll();

    }






    // STUDENT VIEW CONNECTED ALUMNI
    @Override
    public List<ConnectedAlumniDTO> getStudentConnections(
            Long studentId) {



        List<Connection> connections =
                connectionRepository
                .findByStudentIdAndStatus(
                        studentId,
                        ConnectionStatus.ACCEPTED
                );



        return connections.stream()
                .map(connection -> {



                    Alumni alumni =
                            alumniRepository
                            .findById(
                                    connection.getAlumniId()
                            )
                            .orElseThrow(
                                () -> new RuntimeException(
                                    "Alumni not found"
                                )
                            );



                    return new ConnectedAlumniDTO(

                            alumni.getAlumniId(),

                            alumni.getUser().getName(),

                            alumni.getCompanyName(),

                            alumni.getDesignation(),

                            alumni.getExpertise()

                    );


                })
                .collect(Collectors.toList());

    }






    // ALUMNI VIEW CONNECTED STUDENTS
    @Override
    public List<ConnectedStudentDTO> getAlumniConnections(
            Long alumniId) {



        List<Connection> connections =
                connectionRepository
                .findByAlumniIdAndStatus(
                        alumniId,
                        ConnectionStatus.ACCEPTED
                );



        return connections.stream()
                .map(connection -> {



                    Student student =
                            studentRepository
                            .findById(
                                    connection.getStudentId()
                            )
                            .orElseThrow(
                                () -> new RuntimeException(
                                    "Student not found"
                                )
                            );



                    return new ConnectedStudentDTO(

                            student.getStudentId(),

                            student.getUser().getName(),

                            student.getCollegeName(),

                            student.getBranch(),

                            student.getSkills()

                    );


                })
                .collect(Collectors.toList());

    }







    // ACCEPT REQUEST
    @Override
    public Connection acceptRequest(Long id) {


        Connection connection =
                connectionRepository
                .findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                            "Connection not found"
                    )
                );



        connection.setStatus(
                ConnectionStatus.ACCEPTED
        );


        return connectionRepository.save(connection);

    }







    // REJECT REQUEST
    @Override
    public Connection rejectRequest(Long id) {


        Connection connection =
                connectionRepository
                .findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                            "Connection not found"
                    )
                );



        connection.setStatus(
                ConnectionStatus.REJECTED
        );


        return connectionRepository.save(connection);

    }







    // DELETE CONNECTION
    @Override
    public void deleteConnection(Long id) {


        connectionRepository.deleteById(id);

    }


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
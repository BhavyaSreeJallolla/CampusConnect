package com.campusconnect.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.dto.AdminDashboardDTO;
import com.campusconnect.repository.UserRepository;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.ConnectionRepository;
import com.campusconnect.service.AdminDashboardService;


@Service
public class AdminDashboardServiceImpl 
        implements AdminDashboardService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private AlumniRepository alumniRepository;


    @Autowired
    private ConnectionRepository connectionRepository;



    @Override
    public AdminDashboardDTO getDashboard() {


        long totalUsers = userRepository.count();


        long totalStudents = studentRepository.count();


        long totalAlumni = alumniRepository.count();


        long totalConnections = connectionRepository.count();



        return new AdminDashboardDTO(
                totalUsers,
                totalStudents,
                totalAlumni,
                totalConnections
        );

    }

}
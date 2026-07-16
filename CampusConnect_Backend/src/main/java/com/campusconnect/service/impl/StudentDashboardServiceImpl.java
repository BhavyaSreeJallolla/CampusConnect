package com.campusconnect.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.dto.StudentDashboardDTO;
import com.campusconnect.entity.Student;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.service.StudentDashboardService;


@Service
public class StudentDashboardServiceImpl 
        implements StudentDashboardService {


    @Autowired
    private StudentRepository studentRepository;



    @Override
    public StudentDashboardDTO getDashboard(Long studentId) {


        Student student =
        studentRepository.findById(studentId)
        .orElseThrow(
        () -> new RuntimeException("Student not found")
        );


        return new StudentDashboardDTO(

            student.getUser().getName(),

            student.getRollNumber(),

            student.getCollegeName(),

            student.getBranch(),

            student.getSkills(),

            0, // guidance later

            0, // connections later

            0, // projects later

            0  // opportunities later

        );

    }

}
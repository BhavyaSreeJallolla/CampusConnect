package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Student;
import com.campusconnect.entity.Alumni;


public interface StudentService {


    Student saveStudent(Student student);


    Student updateStudent(Long studentId, Student student);


    Student getStudentById(Long studentId);


    List<Student> getAllStudents();


    void deleteStudent(Long studentId);
    Student updateMyProfile(String email, Student student);
    void deleteMyProfile(String email);



    // Student Module Extra Features

    List<Alumni> getAllAlumni();


    List<Alumni> searchAlumni(
            String company,
            String skills,
            String role
    );

}
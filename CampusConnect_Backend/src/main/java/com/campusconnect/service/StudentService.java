package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Long studentId, Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    void deleteStudent(Long studentId);

}
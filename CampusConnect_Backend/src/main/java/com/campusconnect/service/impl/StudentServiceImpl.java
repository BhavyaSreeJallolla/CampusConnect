package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Student;
import com.campusconnect.entity.User;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.repository.UserRepository;
import com.campusconnect.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Student saveStudent(Student student) {

        User user = userRepository.findById(student.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        student.setUser(user);

        return studentRepository.save(student);
    }
    @Override
    public Student updateStudent(Long studentId, Student student) {

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setCollegeName(student.getCollegeName());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setYear(student.getYear());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setBio(student.getBio());
        existingStudent.setSkills(student.getSkills());
        existingStudent.setGithubUrl(student.getGithubUrl());
        existingStudent.setLinkedinUrl(student.getLinkedinUrl());
        existingStudent.setProfileImage(student.getProfileImage());
        existingStudent.setCollegeIdCard(student.getCollegeIdCard());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Student getStudentById(Long studentId) {

        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
    @Override
    public Student updateMyProfile(String email, Student student) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student existingStudent = studentRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        if (student.getRollNumber() != null)
            existingStudent.setRollNumber(student.getRollNumber());

        if (student.getCollegeName() != null)
            existingStudent.setCollegeName(student.getCollegeName());

        if (student.getBranch() != null)
            existingStudent.setBranch(student.getBranch());

        if (student.getYear() != null)
            existingStudent.setYear(student.getYear());

        if (student.getPhone() != null)
            existingStudent.setPhone(student.getPhone());

        if (student.getBio() != null)
            existingStudent.setBio(student.getBio());

        if (student.getSkills() != null)
            existingStudent.setSkills(student.getSkills());

        if (student.getGithubUrl() != null)
            existingStudent.setGithubUrl(student.getGithubUrl());

        if (student.getLinkedinUrl() != null)
            existingStudent.setLinkedinUrl(student.getLinkedinUrl());

        if (student.getProfileImage() != null)
            existingStudent.setProfileImage(student.getProfileImage());

        if (student.getCollegeIdCard() != null)
            existingStudent.setCollegeIdCard(student.getCollegeIdCard());

        return studentRepository.save(existingStudent);
    }
    @Override
    public void deleteMyProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        studentRepository.delete(student);

        userRepository.delete(user);
    }
}
package com.campusconnect.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Student;
import com.campusconnect.entity.Alumni;

import com.campusconnect.repository.StudentRepository;
import com.campusconnect.repository.AlumniRepository;

import com.campusconnect.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {



    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private AlumniRepository alumniRepository;




    @Override
    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }





    @Override
    public Student getStudentById(Long studentId){

        return studentRepository.findById(studentId)
                .orElseThrow(
                () -> new RuntimeException("Student not found"));
    }





    @Override
    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }





    @Override
    public Student updateStudent(
            Long studentId,
            Student student){


        Student existing =
                studentRepository.findById(studentId)
                .orElseThrow(
                () -> new RuntimeException("Student not found"));



        existing.setCollegeName(
                student.getCollegeName());

        existing.setBranch(
                student.getBranch());

        existing.setYear(
                student.getYear());

        existing.setPhone(
                student.getPhone());

        existing.setBio(
                student.getBio());

        existing.setSkills(
                student.getSkills());

        existing.setGithubUrl(
                student.getGithubUrl());

        existing.setLinkedinUrl(
                student.getLinkedinUrl());

        existing.setProfileImage(
                student.getProfileImage());


        return studentRepository.save(existing);
    }





    @Override
    public void deleteStudent(Long studentId){

        studentRepository.deleteById(studentId);

    }





    // View All Alumni

    @Override
    public List<Alumni> getAllAlumni(){

        return alumniRepository.findAll();

    }





    // Search Alumni

    @Override
    public List<Alumni> searchAlumni(
            String company,
            String skills,
            String role){



        if(company != null){

            return alumniRepository
            .findByCompanyNameContainingIgnoreCase(company);

        }



        if(skills != null){

            return alumniRepository
            .findByExpertiseContainingIgnoreCase(skills);

        }



        if(role != null){

            return alumniRepository
            .findByDesignationContainingIgnoreCase(role);

        }



        return alumniRepository.findAll();

    }


}
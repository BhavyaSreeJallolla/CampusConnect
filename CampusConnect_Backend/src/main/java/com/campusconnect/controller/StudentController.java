package com.campusconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Student;
import com.campusconnect.entity.Alumni;

import com.campusconnect.service.StudentService;



@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {



    @Autowired
    private StudentService studentService;



    // Create Student
    @PostMapping
    public Student saveStudent(
            @RequestBody Student student){

        return studentService.saveStudent(student);
    }




    // Get Student By ID
    @GetMapping("/{studentId}")
    public Student getStudentById(
            @PathVariable Long studentId){

        return studentService.getStudentById(studentId);
    }




    // Get All Students
    @GetMapping
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }
    @DeleteMapping("/profile")
    public String deleteMyProfile(Authentication authentication) {




    // Update Student
    @PutMapping("/{studentId}")
    public Student updateStudent(
            @PathVariable Long studentId,
            @RequestBody Student student){


        return studentService.updateStudent(studentId, student);

    }





    // Delete Student
    @DeleteMapping("/{studentId}")
    public String deleteStudent(
            @PathVariable Long studentId){


        studentService.deleteStudent(studentId);

        return "Student deleted successfully";

    }





    // View All Alumni Profiles
    @GetMapping("/alumni")
    public List<Alumni> getAllAlumni(){

        return studentService.getAllAlumni();

    }





    // Search Alumni
    @GetMapping("/search")
    public List<Alumni> searchAlumni(

            @RequestParam(required=false) String company,

            @RequestParam(required=false) String skills,

            @RequestParam(required=false) String role

    ){


        return studentService.searchAlumni(
                company,
                skills,
                role
        );

    }
    


}
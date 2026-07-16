package com.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Student;
import com.campusconnect.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Student creates own profile
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Student updates own profile
    @PutMapping("/profile")
    public Student updateMyProfile(@RequestBody Student student,
                                   Authentication authentication) {

        return studentService.updateMyProfile(
                authentication.getName(),
                student);
    }
    @DeleteMapping("/profile")
    public String deleteMyProfile(Authentication authentication) {

        studentService.deleteMyProfile(authentication.getName());

        return "Student account deleted successfully.";
    }
}
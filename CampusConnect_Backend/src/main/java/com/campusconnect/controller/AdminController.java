package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.dto.StatusUpdateRequest;
import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Student;
import com.campusconnect.entity.User;
import com.campusconnect.service.AdminService;
import com.campusconnect.service.AlumniService;
import com.campusconnect.service.StudentService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AlumniService alumniService;

    /*---------------------- USER MANAGEMENT ----------------------*/

    // Approve / Reject User
    @PutMapping("/users/{userId}/status")
    public User updateStatus(@PathVariable Long userId,
                             @RequestBody StatusUpdateRequest request) {

        return adminService.updateStatus(userId, request.getStatus());
    }

    /*---------------------- STUDENT MANAGEMENT ----------------------*/

    // Get All Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student By Id
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    // Update Student
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable Long studentId,
                                 @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    // Delete Student
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {

        studentService.deleteStudent(studentId);

        return "Student deleted successfully.";
    }

    /*---------------------- ALUMNI MANAGEMENT ----------------------*/

    // Get All Alumni
    @GetMapping("/alumni")
    public List<Alumni> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    // Get Alumni By Id
    @GetMapping("/alumni/{alumniId}")
    public Alumni getAlumniById(@PathVariable Long alumniId) {
        return alumniService.getAlumniById(alumniId);
    }

    // Update Alumni
    @PutMapping("/alumni/{alumniId}")
    public Alumni updateAlumni(@PathVariable Long alumniId,
                               @RequestBody Alumni alumni) {

        return alumniService.updateAlumni(alumniId, alumni);
    }

    // Delete Alumni
    @DeleteMapping("/alumni/{alumniId}")
    public String deleteAlumni(@PathVariable Long alumniId) {

        alumniService.deleteAlumni(alumniId);

        return "Alumni deleted successfully.";
    }

}
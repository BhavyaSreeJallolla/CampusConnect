package com.campusconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Student;
import com.campusconnect.entity.User;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRollNumber(String rollNumber);

    boolean existsByRollNumber(String rollNumber);

    // NEW
    Optional<Student> findByUser(User user);

}
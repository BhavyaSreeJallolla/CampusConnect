package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Connection;
import com.campusconnect.entity.Student;

public interface ConnectionRepository
        extends JpaRepository<Connection, Long> {

    List<Connection> findByStudent(Student student);

    List<Connection> findByAlumni(Alumni alumni);
}
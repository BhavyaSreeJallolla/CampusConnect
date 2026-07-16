package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.Guidance;

@Repository
public interface GuidanceRepository extends JpaRepository<Guidance, Long> {

    List<Guidance> findByAlumni(Alumni alumni);

    int countByAlumni(Alumni alumni);

}
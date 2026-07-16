package com.campusconnect.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.dto.AlumniDashboardDTO;
import com.campusconnect.entity.Alumni;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.GuidanceRepository;
import com.campusconnect.service.AlumniDashboardService;
import com.campusconnect.repository.ConnectionRepository;

@Service
public class AlumniDashboardServiceImpl 
        implements AlumniDashboardService {


    @Autowired
    private AlumniRepository alumniRepository;


    @Autowired
    private GuidanceRepository guidanceRepository;



    @Override
    public AlumniDashboardDTO getDashboard(Long alumniId) {


        Alumni alumni =
        alumniRepository.findById(alumniId)
        .orElseThrow(
        () -> new RuntimeException("Alumni not found")
        );


        int guidanceCount =
        guidanceRepository
        .countByAlumni(alumni);



        return new AlumniDashboardDTO(

            alumni.getUser().getName(),

            alumni.getCompanyName(),

            alumni.getDesignation(),

            guidanceCount,

            0, // opportunities later

            0  // student requests later

        );

    }

}
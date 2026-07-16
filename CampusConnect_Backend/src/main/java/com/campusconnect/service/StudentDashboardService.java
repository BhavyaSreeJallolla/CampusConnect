package com.campusconnect.service;

import com.campusconnect.dto.StudentDashboardDTO;

public interface StudentDashboardService {

    StudentDashboardDTO getDashboard(Long studentId);

}
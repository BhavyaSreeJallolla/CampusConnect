package com.campusconnect.dto;


public class AdminDashboardDTO {

    private long totalUsers;

    private long totalStudents;

    private long totalAlumni;

    private long totalConnections;


    public AdminDashboardDTO(
            long totalUsers,
            long totalStudents,
            long totalAlumni,
            long totalConnections) {

        this.totalUsers = totalUsers;
        this.totalStudents = totalStudents;
        this.totalAlumni = totalAlumni;
        this.totalConnections = totalConnections;
    }


    public long getTotalUsers() {
        return totalUsers;
    }


    public long getTotalStudents() {
        return totalStudents;
    }


    public long getTotalAlumni() {
        return totalAlumni;
    }


    public long getTotalConnections() {
        return totalConnections;
    }
}
package com.campusconnect.dto;

public class AlumniDashboardDTO {

    private String name;

    private String companyName;

    private String designation;

    private int guidanceCount;

    private int opportunityCount;

    private int studentRequestCount;


    public AlumniDashboardDTO(
            String name,
            String companyName,
            String designation,
            int guidanceCount,
            int opportunityCount,
            int studentRequestCount
    ) {
        this.name = name;
        this.companyName = companyName;
        this.designation = designation;
        this.guidanceCount = guidanceCount;
        this.opportunityCount = opportunityCount;
        this.studentRequestCount = studentRequestCount;
    }


    public String getName() {
        return name;
    }


    public String getCompanyName() {
        return companyName;
    }


    public String getDesignation() {
        return designation;
    }


    public int getGuidanceCount() {
        return guidanceCount;
    }


    public int getOpportunityCount() {
        return opportunityCount;
    }


    public int getStudentRequestCount() {
        return studentRequestCount;
    }
}
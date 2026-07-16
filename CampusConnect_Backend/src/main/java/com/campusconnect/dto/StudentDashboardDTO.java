package com.campusconnect.dto;

public class StudentDashboardDTO {


    private String name;

    private String rollNumber;

    private String collegeName;

    private String branch;

    private String skills;

    private int guidanceCount;

    private int connectionCount;

    private int projectCount;

    private int opportunityCount;



    public StudentDashboardDTO(
            String name,
            String rollNumber,
            String collegeName,
            String branch,
            String skills,
            int guidanceCount,
            int connectionCount,
            int projectCount,
            int opportunityCount) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.collegeName = collegeName;
        this.branch = branch;
        this.skills = skills;
        this.guidanceCount = guidanceCount;
        this.connectionCount = connectionCount;
        this.projectCount = projectCount;
        this.opportunityCount = opportunityCount;
    }


    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getBranch() {
        return branch;
    }

    public String getSkills() {
        return skills;
    }

    public int getGuidanceCount() {
        return guidanceCount;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public int getOpportunityCount() {
        return opportunityCount;
    }
}
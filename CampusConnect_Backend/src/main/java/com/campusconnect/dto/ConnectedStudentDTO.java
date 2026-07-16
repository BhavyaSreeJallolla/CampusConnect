package com.campusconnect.dto;


public class ConnectedStudentDTO {


    private Long studentId;

    private String name;

    private String collegeName;

    private String branch;

    private String skills;



    public ConnectedStudentDTO(
            Long studentId,
            String name,
            String collegeName,
            String branch,
            String skills) {


        this.studentId = studentId;
        this.name = name;
        this.collegeName = collegeName;
        this.branch = branch;
        this.skills = skills;

    }



    public Long getStudentId() {
        return studentId;
    }


    public String getName() {
        return name;
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

}
package com.campusconnect.dto;


public class ConnectedAlumniDTO {


    private Long alumniId;

    private String name;

    private String companyName;

    private String designation;

    private String expertise;



    public ConnectedAlumniDTO(
            Long alumniId,
            String name,
            String companyName,
            String designation,
            String expertise) {


        this.alumniId = alumniId;
        this.name = name;
        this.companyName = companyName;
        this.designation = designation;
        this.expertise = expertise;

    }



    public Long getAlumniId() {
        return alumniId;
    }


    public void setAlumniId(Long alumniId) {
        this.alumniId = alumniId;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String designation) {
        this.designation = designation;
    }



    public String getExpertise() {
        return expertise;
    }


    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

}
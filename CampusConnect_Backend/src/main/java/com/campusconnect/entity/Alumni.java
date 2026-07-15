package com.campusconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alumni")
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alumniId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private Integer graduationYear;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String designation;

    private Integer experience;

    private String phone;

    @Column(length = 500)
    private String bio;

    private String expertise;

    private String linkedinUrl;

    private String profileImage;

    private String companyIdCard;

    public Alumni() {
    }

    public Alumni(Long alumniId, User user, String collegeName,
                  Integer graduationYear, String companyName,
                  String designation, Integer experience,
                  String phone, String bio, String expertise,
                  String linkedinUrl, String profileImage,
                  String companyIdCard) {
        this.alumniId = alumniId;
        this.user = user;
        this.collegeName = collegeName;
        this.graduationYear = graduationYear;
        this.companyName = companyName;
        this.designation = designation;
        this.experience = experience;
        this.phone = phone;
        this.bio = bio;
        this.expertise = expertise;
        this.linkedinUrl = linkedinUrl;
        this.profileImage = profileImage;
        this.companyIdCard = companyIdCard;
    }

    public Long getAlumniId() {
        return alumniId;
    }

    public void setAlumniId(Long alumniId) {
        this.alumniId = alumniId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCompanyIdCard() {
        return companyIdCard;
    }

    public void setCompanyIdCard(String companyIdCard) {
        this.companyIdCard = companyIdCard;
    }
}
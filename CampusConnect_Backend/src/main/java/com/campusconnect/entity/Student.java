package com.campusconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private Integer year;

    private String phone;

    @Column(length = 500)
    private String bio;

    private String skills;

    private String githubUrl;

    private String linkedinUrl;

    private String profileImage;

    private String collegeIdCard;

    public Student() {
    }

    public Student(Long studentId, User user, String rollNumber,
                   String collegeName, String branch, Integer year,
                   String phone, String bio, String skills,
                   String githubUrl, String linkedinUrl,
                   String profileImage, String collegeIdCard) {

        this.studentId = studentId;
        this.user = user;
        this.rollNumber = rollNumber;
        this.collegeName = collegeName;
        this.branch = branch;
        this.year = year;
        this.phone = phone;
        this.bio = bio;
        this.skills = skills;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.profileImage = profileImage;
        this.collegeIdCard = collegeIdCard;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
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

    public String getCollegeIdCard() {
        return collegeIdCard;
    }

    public void setCollegeIdCard(String collegeIdCard) {
        this.collegeIdCard = collegeIdCard;
    }
}
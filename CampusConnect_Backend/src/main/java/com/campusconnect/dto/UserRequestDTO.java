package com.campusconnect.dto;

import com.campusconnect.enums.Role;
import com.campusconnect.enums.VerificationStatus;

public class UserRequestDTO {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private VerificationStatus status;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long id, String name, String email,
                          Role role, VerificationStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }
}
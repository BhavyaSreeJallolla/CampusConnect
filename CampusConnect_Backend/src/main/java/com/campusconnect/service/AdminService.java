package com.campusconnect.service;

import java.util.List;

import com.campusconnect.dto.UserRequestDTO;
import com.campusconnect.entity.User;
import com.campusconnect.enums.VerificationStatus;

public interface AdminService {

    User updateStatus(Long userId, VerificationStatus status);

    List<UserRequestDTO> getPendingUsers();

}
package com.campusconnect.service;

import com.campusconnect.entity.User;
import com.campusconnect.enums.VerificationStatus;

public interface AdminService {

    User updateStatus(Long userId, VerificationStatus status);

}
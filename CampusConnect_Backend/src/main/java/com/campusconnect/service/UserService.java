package com.campusconnect.service;

import com.campusconnect.dto.LoginRequest;
import com.campusconnect.dto.LoginResponse;
import com.campusconnect.entity.User;

public interface UserService {

    User register(User user);

    LoginResponse login(LoginRequest request);
}
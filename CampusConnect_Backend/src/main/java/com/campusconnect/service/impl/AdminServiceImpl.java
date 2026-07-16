package com.campusconnect.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.dto.UserRequestDTO;
import com.campusconnect.entity.User;
import com.campusconnect.enums.VerificationStatus;
import com.campusconnect.repository.UserRepository;
import com.campusconnect.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    // Update User Status
    @Override
    public User updateStatus(Long userId, VerificationStatus status) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);

        return userRepository.save(user);
    }

    // Get All Pending Users
    @Override
    public List<UserRequestDTO> getPendingUsers() {

        return userRepository.findByStatus(VerificationStatus.PENDING)
                .stream()
                .map(user -> new UserRequestDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus()))
                .collect(Collectors.toList());
    }

}
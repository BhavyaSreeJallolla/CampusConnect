package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.ReferralRequest;

@Repository
public interface ReferralRequestRepository extends JpaRepository<ReferralRequest, Long> {

    List<ReferralRequest> findByStudentStudentId(Long studentId);

    List<ReferralRequest> findByOpportunityId(Long opportunityId);

    List<ReferralRequest> findByStatus(String status);
}
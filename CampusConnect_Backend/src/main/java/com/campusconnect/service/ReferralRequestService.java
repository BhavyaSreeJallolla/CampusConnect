package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.ReferralRequest;

public interface ReferralRequestService {

    // Student requests a referral
    ReferralRequest requestReferral(Long opportunityId, Long studentId);

    // Get all referral requests
    List<ReferralRequest> getAllRequests();

    // Get requests by student
    List<ReferralRequest> getRequestsByStudent(Long studentId);

    // Get requests for an opportunity
    List<ReferralRequest> getRequestsByOpportunity(Long opportunityId);

    // Alumni approves a request
    ReferralRequest approveRequest(Long requestId);

    // Alumni rejects a request
    ReferralRequest rejectRequest(Long requestId);
}
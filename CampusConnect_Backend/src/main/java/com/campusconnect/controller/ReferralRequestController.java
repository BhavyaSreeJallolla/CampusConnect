package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.ReferralRequest;
import com.campusconnect.service.ReferralRequestService;

@RestController
@RequestMapping("/api/referrals")
public class ReferralRequestController {

    @Autowired
    private ReferralRequestService referralRequestService;


    // Student requests a referral
    @PostMapping("/request/{opportunityId}/{studentId}")
    public ReferralRequest requestReferral(
            @PathVariable Long opportunityId,
            @PathVariable Long studentId) {

        System.out.println("========== REFERRAL REQUEST HIT ==========");
        System.out.println("Opportunity ID : " + opportunityId);
        System.out.println("Student ID     : " + studentId);

        ReferralRequest response =
                referralRequestService.requestReferral(
                        opportunityId,
                        studentId
                );

        System.out.println("Referral Request Created Successfully");
        System.out.println("Request ID : " + response.getRequestId());

        return response;
    }


    // Get all referral requests
    @GetMapping
    public List<ReferralRequest> getAllRequests() {

        System.out.println("========== GET ALL REFERRALS ==========");

        return referralRequestService.getAllRequests();
    }


    // Get requests by student
    @GetMapping("/student/{studentId}")
    public List<ReferralRequest> getRequestsByStudent(
            @PathVariable Long studentId) {

        System.out.println("========== GET STUDENT REFERRALS ==========");
        System.out.println("Student ID : " + studentId);

        return referralRequestService.getRequestsByStudent(studentId);
    }


    // Get requests for an opportunity
    @GetMapping("/opportunity/{opportunityId}")
    public List<ReferralRequest> getRequestsByOpportunity(
            @PathVariable Long opportunityId) {

        System.out.println("========== GET OPPORTUNITY REFERRALS ==========");
        System.out.println("Opportunity ID : " + opportunityId);

        return referralRequestService.getRequestsByOpportunity(opportunityId);
    }


    // Approve request
    @PutMapping("/{requestId}/approve")
    public ReferralRequest approveRequest(
            @PathVariable Long requestId) {

        System.out.println("========== APPROVE REFERRAL ==========");
        System.out.println("Request ID : " + requestId);

        return referralRequestService.approveRequest(requestId);
    }


    // Reject request
    @PutMapping("/{requestId}/reject")
    public ReferralRequest rejectRequest(
            @PathVariable Long requestId) {

        System.out.println("========== REJECT REFERRAL ==========");
        System.out.println("Request ID : " + requestId);

        return referralRequestService.rejectRequest(requestId);
    }
}
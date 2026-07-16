package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Opportunity;
import com.campusconnect.entity.ReferralRequest;
import com.campusconnect.entity.Student;
import com.campusconnect.repository.OpportunityRepository;
import com.campusconnect.repository.ReferralRequestRepository;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.service.ReferralRequestService;

@Service
public class ReferralRequestServiceImpl implements ReferralRequestService {

    @Autowired
    private ReferralRequestRepository referralRequestRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ReferralRequest requestReferral(Long opportunityId, Long studentId) {

        Opportunity opportunity = opportunityRepository.findById(opportunityId)
                .orElseThrow(() -> new RuntimeException("Opportunity not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        ReferralRequest request = new ReferralRequest();
        request.setOpportunity(opportunity);
        request.setStudent(student);
        request.setStatus("PENDING");

        return referralRequestRepository.save(request);
    }

    @Override
    public List<ReferralRequest> getAllRequests() {
        return referralRequestRepository.findAll();
    }

    @Override
    public List<ReferralRequest> getRequestsByStudent(Long studentId) {
        return referralRequestRepository.findByStudentStudentId(studentId);
    }

    @Override
    public List<ReferralRequest> getRequestsByOpportunity(Long opportunityId) {
        return referralRequestRepository.findByOpportunityId(opportunityId);
    }

    @Override
    public ReferralRequest approveRequest(Long requestId) {

        ReferralRequest request = referralRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("APPROVED");

        return referralRequestRepository.save(request);
    }

    @Override
    public ReferralRequest rejectRequest(Long requestId) {

        ReferralRequest request = referralRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("REJECTED");

        return referralRequestRepository.save(request);
    }
}
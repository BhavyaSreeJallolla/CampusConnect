package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.Opportunity;

public interface OpportunityService {

    Opportunity createOpportunity(Opportunity opportunity);

    List<Opportunity> getAllOpportunities();

    List<Opportunity> getOpportunitiesByAlumni(Long alumniId);

    Opportunity getOpportunityById(Long id);

    Opportunity updateOpportunity(Long id, Opportunity opportunity);

    void deleteOpportunity(Long id);

}
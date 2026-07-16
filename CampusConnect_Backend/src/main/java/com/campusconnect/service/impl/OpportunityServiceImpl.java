package com.campusconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Opportunity;
import com.campusconnect.repository.OpportunityRepository;
import com.campusconnect.service.OpportunityService;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public Opportunity createOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    @Override
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @Override
    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    @Override
    public Opportunity updateOpportunity(Long id, Opportunity opportunity) {

        Opportunity existingOpportunity = opportunityRepository.findById(id).orElse(null);

        if (existingOpportunity != null) {
            existingOpportunity.setAlumniId(opportunity.getAlumniId());
            existingOpportunity.setCompany(opportunity.getCompany());
            existingOpportunity.setRole(opportunity.getRole());
            existingOpportunity.setDescription(opportunity.getDescription());
            existingOpportunity.setLocation(opportunity.getLocation());
            existingOpportunity.setType(opportunity.getType());

            return opportunityRepository.save(existingOpportunity);
        }

        return null;
    }

    @Override
    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }
}
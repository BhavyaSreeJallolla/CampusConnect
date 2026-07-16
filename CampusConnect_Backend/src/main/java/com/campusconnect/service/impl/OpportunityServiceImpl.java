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
    public List<Opportunity> getOpportunitiesByAlumni(Long alumniId) {

        return opportunityRepository.findByAlumniId(alumniId);
    }


    @Override
    public Opportunity getOpportunityById(Long id) {

        return opportunityRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Opportunity not found")
                );
    }


    @Override
    public Opportunity updateOpportunity(Long id, Opportunity opportunity) {

        Opportunity existing =
                opportunityRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Opportunity not found")
                );


        existing.setTitle(opportunity.getTitle());
        existing.setCompanyName(opportunity.getCompanyName());
        existing.setDescription(opportunity.getDescription());
        existing.setType(opportunity.getType());
        existing.setAlumniId(opportunity.getAlumniId());


        return opportunityRepository.save(existing);
    }


    @Override
    public void deleteOpportunity(Long id) {

        opportunityRepository.deleteById(id);
    }

}
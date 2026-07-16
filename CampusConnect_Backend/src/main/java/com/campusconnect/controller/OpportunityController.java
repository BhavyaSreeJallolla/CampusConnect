package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Opportunity;
import com.campusconnect.service.OpportunityService;

@RestController
@RequestMapping("/api/opportunities")
@CrossOrigin("*")
public class OpportunityController {


    @Autowired
    private OpportunityService opportunityService;


    // Create Opportunity
    @PostMapping
    public Opportunity createOpportunity(
            @RequestBody Opportunity opportunity) {

        return opportunityService.createOpportunity(opportunity);
    }


    // Get All Opportunities
    @GetMapping
    public List<Opportunity> getAllOpportunities() {

        return opportunityService.getAllOpportunities();
    }


    // Get Opportunities By Alumni
    @GetMapping("/alumni/{alumniId}")
    public List<Opportunity> getByAlumni(
            @PathVariable Long alumniId) {

        return opportunityService.getOpportunitiesByAlumni(alumniId);
    }


    // Get Opportunity By Id
    @GetMapping("/{id}")
    public Opportunity getById(
            @PathVariable Long id) {

        return opportunityService.getOpportunityById(id);
    }


    // Update Opportunity
    @PutMapping("/{id}")
    public Opportunity updateOpportunity(
            @PathVariable Long id,
            @RequestBody Opportunity opportunity) {

        return opportunityService.updateOpportunity(id, opportunity);
    }


    // Delete Opportunity
    @DeleteMapping("/{id}")
    public String deleteOpportunity(
            @PathVariable Long id) {

        opportunityService.deleteOpportunity(id);

        return "Opportunity deleted successfully";
    }

}
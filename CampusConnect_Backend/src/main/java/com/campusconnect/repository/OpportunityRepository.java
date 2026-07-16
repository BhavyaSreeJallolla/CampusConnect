package com.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

}
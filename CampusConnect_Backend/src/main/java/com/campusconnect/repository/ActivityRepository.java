package com.campusconnect.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.campusconnect.entity.Activity;


public interface ActivityRepository 
        extends JpaRepository<Activity, Long>{

}
package com.campusconnect.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Activity;
import com.campusconnect.repository.ActivityRepository;
import com.campusconnect.service.ActivityService;


@Service
public class ActivityServiceImpl 
        implements ActivityService {


    @Autowired
    private ActivityRepository activityRepository;



    @Override
    public List<Activity> getActivities() {

        return activityRepository.findAll();

    }

}
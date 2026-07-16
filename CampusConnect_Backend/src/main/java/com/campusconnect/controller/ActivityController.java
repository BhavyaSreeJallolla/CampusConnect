package com.campusconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Activity;
import com.campusconnect.service.ActivityService;


@RestController
@RequestMapping("/api/admin/activity")
@CrossOrigin("*")
public class ActivityController {


    @Autowired
    private ActivityService activityService;



    @GetMapping
    public List<Activity> getActivities(){

        return activityService.getActivities();

    }

}
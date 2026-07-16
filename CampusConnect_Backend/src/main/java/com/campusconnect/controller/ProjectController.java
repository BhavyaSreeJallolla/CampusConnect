package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.Project;
import com.campusconnect.entity.ProjectRequest;
import com.campusconnect.service.ProjectService;

@RestController
@RequestMapping("/api/projects")

public class ProjectController {

    @Autowired
    private ProjectService projectService;

    }
}
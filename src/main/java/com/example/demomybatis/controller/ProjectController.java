package com.example.demomybatis.controller;

import com.example.demomybatis.model.Project;
import com.example.demomybatis.model.request.ProjectRequest;
import com.example.demomybatis.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Projects")
public class ProjectController {

    private final ProjectService projectService;
    public ProjectController (ProjectService projectService){
        this.projectService = projectService;
    }

    // Get all From Projects
    @GetMapping
    public List<Project> getAllProjects(){
        return  projectService.getAllProjects();
    }
    // Get Project by Id
    @GetMapping("/{id}")
    public Project getProjectById(Integer projectId){
        return  projectService.getProjectById(projectId);
    }

    // Create Project
    @PostMapping
    public Project addProject(@RequestBody ProjectRequest projectRequest){
        return  projectService.addProject(projectRequest);
    }

    // Upate Projects
    @PutMapping("/{id}")
    public  Project updateProject(@PathVariable("id") Integer projectId, @RequestBody  ProjectRequest projectRequest){
        return  projectService.updateProject(projectId,projectRequest);
    }

    // Delete Projects
    @DeleteMapping("/{id}")
    public  Project deleteProject(@PathVariable("id") Integer projectId){
        return  projectService.deleteProject(projectId);
    }
}
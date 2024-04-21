package com.example.demomybatis.service;

import com.example.demomybatis.model.Project;
import com.example.demomybatis.model.request.ProjectRequest;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    Project getProjectById(Integer projectId);

    Project addProject(ProjectRequest projectRequest);

    Project updateProject(Integer projectId, ProjectRequest projectRequest);

    Project deleteProject(Integer projectId);
}
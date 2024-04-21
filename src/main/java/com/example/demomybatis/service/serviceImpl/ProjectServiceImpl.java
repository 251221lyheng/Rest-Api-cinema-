package com.example.demomybatis.service.serviceImpl;

import com.example.demomybatis.model.Project;
import com.example.demomybatis.model.request.ProjectRequest;
import com.example.demomybatis.repository.ProjectRepository;
import com.example.demomybatis.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    @Override
    public Project getProjectById(Integer projectId) {
        return projectRepository.getProjectById(projectId);
    }

    @Override
    public Project addProject(ProjectRequest projectRequest) {
        return projectRepository.addProject(projectRequest);
    }

    @Override
    public Project updateProject(Integer projectId, ProjectRequest projectRequest) {
        return projectRepository.updateProject(projectId, projectRequest);
    }

    @Override
    public Project deleteProject(Integer projectId) {
        return projectRepository.deleteProject(projectId);
    }
}
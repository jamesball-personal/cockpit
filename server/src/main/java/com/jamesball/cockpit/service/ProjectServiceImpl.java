package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Project;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", id);
        }
    }

}

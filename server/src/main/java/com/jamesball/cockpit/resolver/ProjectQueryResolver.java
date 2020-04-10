package com.jamesball.cockpit.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.cockpit.entity.Project;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectQueryResolver implements GraphQLQueryResolver {

    private ProjectRepository projectRepository;

    public ProjectQueryResolver(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

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

package com.jamesball.cockpit.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jamesball.cockpit.entity.Project;
import com.jamesball.cockpit.enumeration.LifeCycleStatus;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectMutationResolver implements GraphQLMutationResolver {

    private ProjectRepository projectRepository;

    public ProjectMutationResolver(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(String name, String description, LifeCycleStatus lifeCycleStatus) {
        Project project = new Project(name, description, lifeCycleStatus);
        projectRepository.save(project);
        return project;
    }

    public Boolean deleteProject(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    public Project updateProjectName(Long id, String newName) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(newName);
            projectRepository.save(project);
            return project;
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", id);
        }
    }

    public Project updateProjectDescription(Long id, String newDescription) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setDescription(newDescription);
            projectRepository.save(project);
            return project;
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", id);
        }
    }

    public Project updateProjectLifeCycleStatus(Long id, LifeCycleStatus newLifeCycleStatus) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setLifeCycleStatus(newLifeCycleStatus);
            projectRepository.save(project);
            return project;
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", id);
        }
    }
}

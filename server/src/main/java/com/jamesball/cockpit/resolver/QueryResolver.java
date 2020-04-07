package com.jamesball.cockpit.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.cockpit.entity.*;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private MetricRepository metricRepository;
    private ObjectiveRepository objectiveRepository;
    private ProjectRepository projectRepository;

    public QueryResolver(
            ObjectiveRepository objectiveRepository,
            MetricRepository metricRepository,
            ProjectRepository projectRepository
    ) {
        this.metricRepository = metricRepository;
        this.objectiveRepository = objectiveRepository;
        this.projectRepository = projectRepository;
    }

    public Iterable<Metric> findAllMetrics() {
        return metricRepository.findAll();
    }

    public Metric findMetric(Long id) {
        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            return optionalMetric.get();
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", id);
        }
    }

    public Iterable<Objective> findAllObjectives() {
        return objectiveRepository.findAll();
    }

    public Objective findObjective(Long id) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            return optionalObjective.get();
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", id);
        }
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

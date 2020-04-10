package com.jamesball.cockpit.controller;

import com.jamesball.cockpit.entity.*;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cockpit")
public class CockpitApplicationRestController {

    private MetricService metricService;
    private ObjectiveService objectiveService;
    private ProjectService projectService;

    @Autowired
    public void setMetricService(MetricService metricService) {
        this.metricService = metricService;
    }

    @Autowired
    public void setObjectiveService(ObjectiveService objectiveService) {
        this.objectiveService = objectiveService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/metric")
    public ResponseEntity<List<Metric>> getAllMetrics() {
        List<Metric> metrics = metricService.findAllMetrics();
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    @GetMapping("/metric/{id}")
    public ResponseEntity<Metric> getMetric(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Metric>(metricService.findMetric(id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Metric Not Found");
        }
    }

    @GetMapping("/objective")
    public ResponseEntity<List<Objective>> getAllObjectives() {
        List<Objective> objectives = objectiveService.findAllObjectives();
        return new ResponseEntity<>(objectives, HttpStatus.OK);
    }

    @GetMapping("/objective/{id}")
    public ResponseEntity<Objective> getObjective(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Objective>(objectiveService.findObjective(id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Objective Not Found");
        }
    }

    @GetMapping("/project")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Project>(projectService.findProject(id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found");
        }
    }

}

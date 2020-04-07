package com.jamesball.datawarehouse.controller;

import com.jamesball.datawarehouse.entity.*;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.service.*;
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
@RequestMapping("/dwa")
public class DataWarehouseApplicationController {

    private MetricService metricService;
    private ObjectiveService objectiveService;
    private PlanItemService planItemService;
    private ProjectService projectService;
    private SnapshotService snapshotService;

    @Autowired
    public void setMetricService(MetricService metricService) {
        this.metricService = metricService;
    }

    @Autowired
    public void setObjectiveService(ObjectiveService objectiveService) {
        this.objectiveService = objectiveService;
    }

    @Autowired
    public void setPlanItemService(PlanItemService planItemService) {
        this.planItemService = planItemService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setSnapshotService(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    @GetMapping("/snapshot/{snapshotId}/metric")
    public ResponseEntity<List<Metric>> getAllMetrics(@PathVariable("snapshotId") Long snapshotId) {
        List<Metric> metrics = metricService.findAllMetrics(snapshotId);
        return new ResponseEntity<List<Metric>>(metrics, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{snapshotId}/metric/{id}")
    public ResponseEntity<Metric> getMetric(@PathVariable("snapshotId") Long snapshotId, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Metric>(metricService.findMetric(snapshotId, id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Metric Not Found");
        }
    }

    @GetMapping("/snapshot/{snapshotId}/objective")
    public ResponseEntity<List<Objective>> getAllObjectives(@PathVariable("snapshotId") Long snapshotId) {
        List<Objective> objectives = objectiveService.findAllObjectives(snapshotId);
        return new ResponseEntity<List<Objective>>(objectives, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{snapshotId}/objective/{id}")
    public ResponseEntity<Objective> getObjective(@PathVariable("snapshotId") Long snapshotId, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Objective>(objectiveService.findObjective(snapshotId, id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Objective Not Found");
        }
    }

    @GetMapping("/snapshot/{snapshotId}/planItem")
    public ResponseEntity<List<PlanItem>> getAllPlanItems(@PathVariable("snapshotId") Long snapshotId) {
        List<PlanItem> planItems = planItemService.findAllPlanItems(snapshotId);
        return new ResponseEntity<List<PlanItem>>(planItems, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{snapshotId}/planItem/{id}")
    public ResponseEntity<PlanItem> getPlanItem(@PathVariable("snapshotId") Long snapshotId, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<PlanItem>(planItemService.findPlanItem(snapshotId, id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan Item Not Found");
        }
    }

    @GetMapping("/snapshot/{snapshotId}/project")
    public ResponseEntity<List<Project>> getAllProjects(@PathVariable("snapshotId") Long snapshotId) {
        List<Project> projects = projectService.findAllProjects(snapshotId);
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{snapshotId}/project/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("snapshotId") Long snapshotId, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Project>(projectService.findProject(snapshotId, id), HttpStatus.OK);
        }
        catch (PlanItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found");
        }
    }

    @GetMapping("/snapshot")
    public ResponseEntity<List<Snapshot>> getAllSnapshots() {
        List<Snapshot> snapshots = snapshotService.findAllSnapshots();
        return new ResponseEntity<List<Snapshot>>(snapshots, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{id}")
    public ResponseEntity<Snapshot> getSnapshot(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Snapshot>(snapshotService.findSnapshot(id), HttpStatus.OK);
        }
        catch (SnapshotNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Snapshot Not Found");
        }
    }
}

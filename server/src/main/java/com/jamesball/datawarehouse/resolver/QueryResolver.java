package com.jamesball.datawarehouse.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.datawarehouse.entity.*;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.repository.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private MetricRepository metricRepository;
    private ObjectiveRepository objectiveRepository;
    private PlanItemRepository planItemRepository;
    private ProjectRepository projectRepository;
    private SnapshotRepository snapshotRepository;

    public QueryResolver(
            ObjectiveRepository objectiveRepository,
            MetricRepository metricRepository,
            PlanItemRepository planItemRepository,
            ProjectRepository projectRepository,
            SnapshotRepository snapshotRepository
    ) {
        this.metricRepository = metricRepository;
        this.objectiveRepository = objectiveRepository;
        this.planItemRepository = planItemRepository;
        this.projectRepository = projectRepository;
        this.snapshotRepository = snapshotRepository;
    }

    public Iterable<Metric> findAllMetrics(Long snapshotId) {
        return metricRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    public Metric findMetric(Long snapshotId, Long id) {
        Snapshot snapshot = findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Metric> optionalMetric = metricRepository.findById(planItemId);

        if (optionalMetric.isPresent()) {
            return optionalMetric.get();
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", planItemId);
        }
    }

    public Iterable<Objective> findAllObjectives(Long snapshotId) {
        return objectiveRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    public Objective findObjective(Long snapshotId, Long id) {
        Snapshot snapshot = findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Objective> optionalObjective = objectiveRepository.findById(planItemId);

        if (optionalObjective.isPresent()) {
            return optionalObjective.get();
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", planItemId);
        }
    }

    public Iterable<PlanItem> findAllPlanItems(Long snapshotId) {
        return planItemRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    public PlanItem findPlanItem(Long snapshotId, Long id) {
        Snapshot snapshot = findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<PlanItem> optionalPlanItem = planItemRepository.findById(planItemId);

        if (optionalPlanItem.isPresent()) {
            return optionalPlanItem.get();
        }
        else {
            throw new PlanItemNotFoundException("Plan Item Not Found", planItemId);
        }
    }

    public Iterable<Project> findAllProjects(Long snapshotId) {
        return projectRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    public Project findProject(Long snapshotId, Long id) {
        Snapshot snapshot = findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Project> optionalProject = projectRepository.findById(planItemId);

        if (optionalProject.isPresent()) {
            return optionalProject.get();
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", planItemId);
        }
    }

    public Iterable<Snapshot> findAllSnapshots() {
        return snapshotRepository.findAll();
    }

    public Snapshot findSnapshot(Long id) {
        Optional<Snapshot> optionalSnapshot = snapshotRepository.findById(id);

        if (optionalSnapshot.isPresent()) {
            return optionalSnapshot.get();
        }
        else {
            throw new SnapshotNotFoundException("Snapshot Not Found", id);
        }
    }
}

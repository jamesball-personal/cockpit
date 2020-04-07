package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.entity.Project;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private SnapshotService snapshotService;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects(Long snapshotId) {
        return (List<Project>) projectRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    @Override
    public Project findProject(Long snapshotId, Long id) {
        Snapshot snapshot = snapshotService.findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Project> optionalProject = projectRepository.findById(planItemId);

        if (optionalProject.isPresent()) {
            return optionalProject.get();
        }
        else {
            throw new PlanItemNotFoundException("Project Not Found", planItemId);
        }
    }
}

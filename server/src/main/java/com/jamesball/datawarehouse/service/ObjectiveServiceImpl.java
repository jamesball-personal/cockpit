package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Objective;
import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.repository.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

    @Autowired
    private SnapshotService snapshotService;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Override
    public List<Objective> findAllObjectives(Long snapshotId) {
        return (List<Objective>) objectiveRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    @Override
    public Objective findObjective(Long snapshotId, Long id) {
        Snapshot snapshot = snapshotService.findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Objective> optionalObjective = objectiveRepository.findById(planItemId);

        if (optionalObjective.isPresent()) {
            return optionalObjective.get();
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", planItemId);
        }
    }
}

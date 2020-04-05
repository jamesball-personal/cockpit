package com.jamesball.datawarehouse.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.datawarehouse.entity.PlanItem;
import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.repository.PlanItemRepository;
import com.jamesball.datawarehouse.repository.SnapshotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private SnapshotRepository snapshotRepository;
    private PlanItemRepository planItemRepository;

    public QueryResolver(SnapshotRepository snapshotRepository, PlanItemRepository planItemRepository) {
        this.snapshotRepository = snapshotRepository;
        this.planItemRepository = planItemRepository;
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
}

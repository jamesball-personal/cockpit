package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.PlanItem;
import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.repository.PlanItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanItemServiceImpl implements PlanItemService {

    @Autowired
    private SnapshotService snapshotService;

    @Autowired
    private PlanItemRepository planItemRepository;

    @Override
    public List<PlanItem> findAllPlanItems(Long snapshotId) {
        return (List<PlanItem>) planItemRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    @Override
    public PlanItem findPlanItem(Long snapshotId, Long id) {
        Snapshot snapshot = snapshotService.findSnapshot(snapshotId);
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

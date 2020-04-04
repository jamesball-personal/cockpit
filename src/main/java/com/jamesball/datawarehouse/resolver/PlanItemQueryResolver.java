package com.jamesball.datawarehouse.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.datawarehouse.entity.PlanItem;
import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.repository.PlanItemRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanItemQueryResolver implements GraphQLQueryResolver {

    private PlanItemRepository planItemRepository;

    public PlanItemQueryResolver(PlanItemRepository planItemRepository) {
        this.planItemRepository = planItemRepository;
    }

    public Iterable<PlanItem> findAllPlanItems(Long snapshotId) {
        return planItemRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    public PlanItem findPlanItem(Long snapshotId, Long id) {
        PlanItemId planItemId = new PlanItemId(snapshotId, id);
        Optional<PlanItem> optionalPlanItem = planItemRepository.findById(planItemId);

        if (optionalPlanItem.isPresent()) {
            return optionalPlanItem.get();
        }
        else {
            throw new PlanItemNotFoundException("Plan Item Not Found", planItemId);
        }
    }
}

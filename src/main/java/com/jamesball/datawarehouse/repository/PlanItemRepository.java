package com.jamesball.datawarehouse.repository;

import com.jamesball.datawarehouse.entity.PlanItem;
import com.jamesball.datawarehouse.entity.PlanItemId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanItemRepository extends CrudRepository<PlanItem, PlanItemId>{

    List<PlanItem> findByPlanItemIdSnapshotId(Long snapshotId);
}

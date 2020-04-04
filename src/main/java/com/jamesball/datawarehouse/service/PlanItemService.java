package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.PlanItem;

import java.util.List;

public interface PlanItemService {

    List<PlanItem> findAllPlanItems(Long snapshotId);

    PlanItem findPlanItem(Long snapshotId, Long id);
}

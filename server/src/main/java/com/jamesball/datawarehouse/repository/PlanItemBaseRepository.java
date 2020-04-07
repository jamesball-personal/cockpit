package com.jamesball.datawarehouse.repository;

import com.jamesball.datawarehouse.entity.PlanItem;
import com.jamesball.datawarehouse.entity.PlanItemId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PlanItemBaseRepository<T extends PlanItem> extends CrudRepository<T, PlanItemId> {

    public List<T> findByPlanItemIdSnapshotId(Long snapshotId);
}

package com.jamesball.datawarehouse.entity;

import com.jamesball.datawarehouse.enumeration.LifecycleStatus;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashMap;
import java.util.Map;

@Entity(name = "PlanItem")
@Table(name = "plan_item")
public class PlanItem {

    @EmbeddedId
    private PlanItemId planItemId;

    @Column(name = "owner_personnel_id", nullable = false)
    private Long ownerPersonnelId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "lifecycle_status", nullable = false)
    private LifecycleStatus lifecycleStatus;

    public PlanItem() {
    }

    public PlanItem(
        PlanItemId planItemId,
        Long ownerPersonnelId,
        String name,
        String description,
        LifecycleStatus lifecycleStatus
    ) {
        this.planItemId = planItemId;
        this.ownerPersonnelId = ownerPersonnelId;
        this.name = name;
        this.description = description;
        this.lifecycleStatus = lifecycleStatus;
    }

    public Map<String, Long> getId() {
        return new HashMap<>() {{
            put("snapshotId", planItemId.getSnapshot().getId());
            put("id", planItemId.getId());
        }};
    }

    public Long getOwnerPersonnelId() {
        return ownerPersonnelId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LifecycleStatus getLifecycleStatus() {
        return lifecycleStatus;
    }
}

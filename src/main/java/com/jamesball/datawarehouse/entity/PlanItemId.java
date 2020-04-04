package com.jamesball.datawarehouse.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlanItemId implements Serializable {

    @Column(name = "snapshot_id")
    private Long snapshotId;

    @Column(name = "id")
    private Long id;

    public PlanItemId() {
    }

    public PlanItemId(Long snapshotId , Long id) {
        this.snapshotId = snapshotId;
        this.id = id;
    }

    public Long getSnapshotId() {
        return snapshotId;
    }

    public Long getId() {
        return id;
    }
}

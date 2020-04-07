package com.jamesball.datawarehouse.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class PlanItemId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "snapshot_id")
    private Snapshot snapshot;

    @Column(name = "id")
    private Long id;

    public PlanItemId() {}

    public PlanItemId(Snapshot snapshot, Long id) {
        this.snapshot = snapshot;
        this.id = id;
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public Long getId() {
        return id;
    }
}

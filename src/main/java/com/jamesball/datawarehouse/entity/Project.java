package com.jamesball.datawarehouse.entity;

import javax.persistence.*;

@Entity(name = "Project")
@Table(name = "project")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "snapshot_id", referencedColumnName = "snapshot_id"),
        @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
})
public class Project extends PlanItem {

    @Column(name = "actualPercentageComplete", nullable = false)
    private Double actualPercentageComplete;

    @Column(name = "targetPercentageComplete", nullable = false)
    private Double targetPercentageComplete;

    public Project() {}

    public Project(Double actualPercentageComplete, Double targetPercentageComplete) {
        this.actualPercentageComplete = actualPercentageComplete;
        this.targetPercentageComplete = targetPercentageComplete;
    }

    public Double getActualPercentageComplete() {
        return actualPercentageComplete;
    }

    public Double getTargetPercentageComplete() {
        return targetPercentageComplete;
    }
}

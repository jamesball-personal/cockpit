package com.jamesball.datawarehouse.entity;

import javax.persistence.*;

@Entity(name = "Metric")
@Table(name = "metric")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "snapshot_id", referencedColumnName = "snapshot_id"),
        @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
})
public class Metric extends PlanItem {

    @Column(name = "unit_of_measure", nullable = false)
    private String unitOfMeasure;

    public Metric() {}

    public Metric(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
}

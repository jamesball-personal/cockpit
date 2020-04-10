package com.jamesball.cockpit.entity;

import com.jamesball.cockpit.enumeration.LifeCycleStatus;

import javax.persistence.*;

@Entity
@Table(name = "metric")
public class Metric extends PlanItem {

    public Metric() {}

    public Metric(String name, String description, LifeCycleStatus lifeCycleStatus) {
        super(name, description, lifeCycleStatus);
    }

}

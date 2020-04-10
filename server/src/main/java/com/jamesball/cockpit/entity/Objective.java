package com.jamesball.cockpit.entity;

import com.jamesball.cockpit.enumeration.LifeCycleStatus;

import javax.persistence.*;

@Entity
@Table(name = "objective")
public class Objective extends PlanItem {

    public Objective() {}

    public Objective(String name, String description, LifeCycleStatus lifeCycleStatus) {
        super(name, description, lifeCycleStatus);
    }

}

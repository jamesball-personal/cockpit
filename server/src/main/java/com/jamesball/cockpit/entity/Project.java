package com.jamesball.cockpit.entity;

import com.jamesball.cockpit.enumeration.LifeCycleStatus;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project extends PlanItem {

    public Project() {}

    public Project(String name, String description, LifeCycleStatus lifeCycleStatus) {
        super(name, description, lifeCycleStatus);
    }

}

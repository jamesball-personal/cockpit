package com.jamesball.cockpit.entity;

import com.jamesball.cockpit.enumeration.LifeCycleStatus;

import javax.persistence.*;

@Entity
@Table(name = "plan_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class PlanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "life_cycle_status", nullable = false)
    private LifeCycleStatus lifeCycleStatus;

    public PlanItem() {}

    public PlanItem(String name, String description, LifeCycleStatus lifeCycleStatus) {
        this.name = name;
        this.description = description;
        this.lifeCycleStatus = lifeCycleStatus;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LifeCycleStatus getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public void setLifeCycleStatus(LifeCycleStatus lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }
}

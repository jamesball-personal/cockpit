package com.jamesball.datawarehouse.entity;

import javax.persistence.*;

@Entity(name = "Objective")
@Table(name = "objective")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "snapshot_id", referencedColumnName = "snapshot_id"),
        @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
})
public class Objective extends PlanItem {}

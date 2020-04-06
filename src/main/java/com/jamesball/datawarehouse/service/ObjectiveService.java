package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Objective;

import java.util.List;

public interface ObjectiveService {

    List<Objective> findAllObjectives(Long snapshotId);

    Objective findObjective(Long snapshotId, Long id);
}

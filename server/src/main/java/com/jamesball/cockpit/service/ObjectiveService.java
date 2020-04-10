package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Objective;

import java.util.List;

public interface ObjectiveService {

    List<Objective> findAllObjectives();

    Objective findObjective(Long id);

}

package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProjects();

    Project findProject(Long id);
}

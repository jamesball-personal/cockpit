package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProjects(Long snapshotId);

    Project findProject(Long snapshotId, Long id);
}

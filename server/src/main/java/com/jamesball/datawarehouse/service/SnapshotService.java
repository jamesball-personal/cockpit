package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Snapshot;

import java.util.List;

public interface SnapshotService {

    List<Snapshot> findAllSnapshots();

    Snapshot findSnapshot(Long id);
}

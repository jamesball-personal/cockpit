package com.jamesball.datawarehouse.repository;

import com.jamesball.datawarehouse.entity.Snapshot;
import org.springframework.data.repository.CrudRepository;

public interface SnapshotRepository extends CrudRepository<Snapshot, Long> {
}
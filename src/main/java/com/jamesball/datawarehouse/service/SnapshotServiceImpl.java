package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.repository.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnapshotServiceImpl implements SnapshotService {

    private SnapshotRepository snapshotRepository;

    @Override
    public List<Snapshot> findAllSnapshots() {
        return (List<Snapshot>) snapshotRepository.findAll();
    }

    @Override
    public Snapshot findSnapshot(Long id) {
        Optional<Snapshot> optionalSnapshot = snapshotRepository.findById(id);

        if (optionalSnapshot.isPresent()) {
            return optionalSnapshot.get();
        }
        else {
            throw new SnapshotNotFoundException("Snapshot Not Found", id);
        }
    }
}
package com.jamesball.datawarehouse.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.repository.SnapshotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SnapshotQueryResolver implements GraphQLQueryResolver {

    private SnapshotRepository snapshotRepository;

    public SnapshotQueryResolver(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    public Iterable<Snapshot> findAllSnapshots() {
        return snapshotRepository.findAll();
    }

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

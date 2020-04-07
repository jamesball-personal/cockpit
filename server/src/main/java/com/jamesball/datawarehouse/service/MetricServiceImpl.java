package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Metric;
import com.jamesball.datawarehouse.entity.PlanItemId;
import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.PlanItemNotFoundException;
import com.jamesball.datawarehouse.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetricServiceImpl implements MetricService {

    @Autowired
    private SnapshotService snapshotService;

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public List<Metric> findAllMetrics(Long snapshotId) {
        return (List<Metric>) metricRepository.findByPlanItemIdSnapshotId(snapshotId);
    }

    @Override
    public Metric findMetric(Long snapshotId, Long id) {
        Snapshot snapshot = snapshotService.findSnapshot(snapshotId);
        PlanItemId planItemId = new PlanItemId(snapshot, id);
        Optional<Metric> optionalMetric = metricRepository.findById(planItemId);

        if (optionalMetric.isPresent()) {
            return optionalMetric.get();
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", planItemId);
        }
    }
}

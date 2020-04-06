package com.jamesball.datawarehouse.service;

import com.jamesball.datawarehouse.entity.Metric;

import java.util.List;

public interface MetricService {

    List<Metric> findAllMetrics(Long snapshotId);

    Metric findMetric(Long snapshotId, Long id);
}

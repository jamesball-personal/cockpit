package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Metric;

import java.util.List;

public interface MetricService {

    List<Metric> findAllMetrics();

    Metric findMetric(Long id);

}

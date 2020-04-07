package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Metric;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetricServiceImpl implements MetricService {

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public List<Metric> findAllMetrics() {
        return (List<Metric>) metricRepository.findAll();
    }

    @Override
    public Metric findMetric(Long id) {
        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            return optionalMetric.get();
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", id);
        }
    }
}

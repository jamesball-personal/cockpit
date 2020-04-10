package com.jamesball.cockpit.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.cockpit.entity.Metric;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.MetricRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MetricQueryResolver implements GraphQLQueryResolver {

    private MetricRepository metricRepository;

    public MetricQueryResolver(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public Iterable<Metric> findAllMetrics() {
        return metricRepository.findAll();
    }

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

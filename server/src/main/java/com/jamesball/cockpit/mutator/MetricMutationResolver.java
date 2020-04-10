package com.jamesball.cockpit.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jamesball.cockpit.entity.Metric;
import com.jamesball.cockpit.enumeration.LifeCycleStatus;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.MetricRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MetricMutationResolver implements GraphQLMutationResolver {

    private MetricRepository metricRepository;

    public MetricMutationResolver(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public Metric createMetric(String name, String description, LifeCycleStatus lifeCycleStatus) {
        Metric metric = new Metric(name, description, lifeCycleStatus);
        metricRepository.save(metric);
        return metric;
    }

    public Boolean deleteMetric(Long id) {
        metricRepository.deleteById(id);
        return true;
    }

    public Metric updateMetricName(Long id, String newName) {
        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            Metric metric = optionalMetric.get();
            metric.setName(newName);
            metricRepository.save(metric);
            return metric;
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", id);
        }
    }

    public Metric updateMetricDescription(Long id, String newDescription) {
        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            Metric metric = optionalMetric.get();
            metric.setDescription(newDescription);
            metricRepository.save(metric);
            return metric;
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", id);
        }
    }

    public Metric updateMetricLifeCycleStatus(Long id, LifeCycleStatus newLifeCycleStatus) {
        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            Metric metric = optionalMetric.get();
            metric.setLifeCycleStatus(newLifeCycleStatus);
            metricRepository.save(metric);
            return metric;
        }
        else {
            throw new PlanItemNotFoundException("Metric Not Found", id);
        }
    }

}

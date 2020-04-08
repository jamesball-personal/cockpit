package com.jamesball.cockpit.repository;

import com.jamesball.cockpit.entity.Metric;
import org.springframework.data.repository.CrudRepository;

public interface MetricRepository extends CrudRepository<Metric, Long> {}

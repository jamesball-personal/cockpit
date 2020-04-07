package com.jamesball.cockpit.repository;

import com.jamesball.cockpit.entity.PlanItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PlanItemRepository<T extends PlanItem> extends CrudRepository<T, Long> {}

package com.jamesball.cockpit.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jamesball.cockpit.entity.Objective;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ObjectiveRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObjectiveQueryResolver implements GraphQLQueryResolver {

    private ObjectiveRepository objectiveRepository;

    public ObjectiveQueryResolver(ObjectiveRepository objectiveRepository) {
        this.objectiveRepository = objectiveRepository;
    }

    public Iterable<Objective> findAllObjectives() {
        return objectiveRepository.findAll();
    }

    public Objective findObjective(Long id) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            return optionalObjective.get();
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", id);
        }
    }

}

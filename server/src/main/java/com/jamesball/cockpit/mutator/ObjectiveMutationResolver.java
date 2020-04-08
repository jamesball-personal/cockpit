package com.jamesball.cockpit.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jamesball.cockpit.entity.Objective;
import com.jamesball.cockpit.enumeration.LifeCycleStatus;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ObjectiveRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObjectiveMutationResolver implements GraphQLMutationResolver {

    private ObjectiveRepository objectiveRepository;

    public ObjectiveMutationResolver(ObjectiveRepository objectiveRepository) {
        this.objectiveRepository = objectiveRepository;
    }

    public Objective createObjective(String name, String description, LifeCycleStatus lifeCycleStatus) {
        Objective objective = new Objective(name, description, lifeCycleStatus);
        objectiveRepository.save(objective);
        return objective;
    }

    public Boolean deleteObjective(Long id) {
        objectiveRepository.deleteById(id);
        return true;
    }

    public Objective updateObjectiveName(Long id, String newName) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            Objective objective = optionalObjective.get();
            objective.setName(newName);
            objectiveRepository.save(objective);
            return objective;
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", id);
        }
    }

    public Objective updateObjectiveDescription(Long id, String newDescription) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            Objective objective = optionalObjective.get();
            objective.setDescription(newDescription);
            objectiveRepository.save(objective);
            return objective;
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", id);
        }
    }

    public Objective updateObjectiveLifeCycleStatus(Long id, LifeCycleStatus newLifeCycleStatus) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            Objective objective = optionalObjective.get();
            objective.setLifeCycleStatus(newLifeCycleStatus);
            objectiveRepository.save(objective);
            return objective;
        }
        else {
            throw new PlanItemNotFoundException("Objective Not Found", id);
        }
    }
}

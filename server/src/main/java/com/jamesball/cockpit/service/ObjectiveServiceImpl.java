package com.jamesball.cockpit.service;

import com.jamesball.cockpit.entity.Objective;
import com.jamesball.cockpit.exception.PlanItemNotFoundException;
import com.jamesball.cockpit.repository.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Override
    public List<Objective> findAllObjectives() {
        return (List<Objective>) objectiveRepository.findAll();
    }

    @Override
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

package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationService;
import ru.fiksiki.petshelter.services.repository.ProbationDogRepository;

@Service
public class ProbationServiceImpl implements ProbationService {

    private final ProbationDogRepository probationDogRepository;

    public ProbationServiceImpl(ProbationDogRepository probationDogRepository) {
        this.probationDogRepository = probationDogRepository;
    }

    @Override
    public void create(ProbationDog probationDog) {
        probationDogRepository.save(probationDog);
    }


}

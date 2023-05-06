package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.AdopterNotFoundException;
import ru.fiksiki.petshelter.model.AdopterDog;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationService;
import ru.fiksiki.petshelter.services.repository.AdopterDogRepository;
import ru.fiksiki.petshelter.services.repository.ProbationDogRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProbationDogServiceImpl implements ProbationService {

    private final ProbationDogRepository probationDogRepository;

    private final AdopterDogRepository adopterDogRepository;

    public ProbationDogServiceImpl(
            ProbationDogRepository probationDogRepository, AdopterDogRepository adopterDogRepository)
    {
        this.probationDogRepository = probationDogRepository;
        this.adopterDogRepository = adopterDogRepository;
    }

    @Override
    public void create(ProbationDog probationDog) {
        probationDogRepository.save(probationDog);
    }

    private AdopterDog readAdopter(long id) {
        if (adopterDogRepository.findById(id).isPresent()) {
            return adopterDogRepository.findById(id).get();
        }
        throw new AdopterNotFoundException();
    }

    @Override
    public List<Long> getAllAdopters() {
        return probationDogRepository.findAll().stream().map(p -> readAdopter(p.getAdopterId()).getUserId())
                                     .collect(Collectors.toList());
    }


}

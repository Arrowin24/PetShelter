package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.UserDogNotFoundException;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.model.UserDog;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.UserDogService;
import ru.fiksiki.petshelter.services.repository.ProbationDogRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProbationDogServiceImpl implements ProbationDogService {

    private final ProbationDogRepository probationDogRepository;
    private final UserDogService userDogService;


    public ProbationDogServiceImpl(
            ProbationDogRepository probationDogRepository,
            UserDogService userDogService)
    {
        this.probationDogRepository = probationDogRepository;
        this.userDogService = userDogService;
    }

    @Override
    public void create(ProbationDog probationDog) {
        probationDogRepository.save(probationDog);
    }

    @Override
    public List<ProbationDog> readAll() {
        return probationDogRepository.findAll();
    }

    @Override
    public ProbationDog read(long id) {
        if (probationDogRepository.findById(id).isPresent()) {
            return probationDogRepository.findById(id).get();
        }
        throw new UserDogNotFoundException();
    }

    @Override
    public void updateLastReportDate(Long id, LocalDate localDate){
        probationDogRepository.updateLastReportBy(id, localDate);
    }

    @Override
    public void updateDayLeft(ProbationDog probationDog) {
        probationDogRepository.updateDayLeft(probationDog.getDayLeft(), probationDog.getId());
    }


    @Override
    public List<Long> getAllAdopters() {
        return probationDogRepository.findAll().stream().map(ProbationDog::getId).collect(Collectors.toList());
    }

    @Override
    public void deleteProbation(ProbationDog probationDog) {
        probationDogRepository.delete(probationDog);
    }

    @Override
    public boolean isProbationDog(Long id) {
        return probationDogRepository.existsById(id);
    }

    @Override
    public UserDog getUserDog(Long id) {
        return userDogService.read(id);
    }

}

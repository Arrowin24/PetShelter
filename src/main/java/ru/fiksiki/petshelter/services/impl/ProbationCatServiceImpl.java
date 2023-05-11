package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.UserDogNotFoundException;

import ru.fiksiki.petshelter.model.ProbationCat;
import ru.fiksiki.petshelter.model.UserCat;
import ru.fiksiki.petshelter.services.ProbationCatService;
import ru.fiksiki.petshelter.services.UserCatService;
import ru.fiksiki.petshelter.services.repository.ProbationCatRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A service implementation for managing probation period for cats adopter.
 */
@Service
public class ProbationCatServiceImpl implements ProbationCatService {

    private final ProbationCatRepository probationCatRepository;
    private final UserCatService userCatService;

    /**
     * Constructs a new instance of the `ProbationCatServiceImpl` class.
     *
     * @param probationCatRepository the repository for managing probation period for cats adopter
     * @param userCatService         the service for managing cats user
     */
    public ProbationCatServiceImpl(ProbationCatRepository probationCatRepository, UserCatService userCatService)
    {
        this.probationCatRepository = probationCatRepository;
        this.userCatService = userCatService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(ProbationCat probationCat) {
        probationCatRepository.save(probationCat);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProbationCat> readAll() {
        return probationCatRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProbationCat read(long id) {
        if (probationCatRepository.findById(id).isPresent()) {
            return probationCatRepository.findById(id).get();
        }
        throw new UserDogNotFoundException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLastReportDate(Long id, LocalDate localDate) {
        probationCatRepository.updateLastReportBy(id, localDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDayLeft(ProbationCat probationCat) {
        probationCatRepository.updateDayLeft(probationCat.getDayLeft(), probationCat.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> getAllAdopters() {
        return probationCatRepository.findAll().stream().map(ProbationCat::getId).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteProbation(ProbationCat probationCat) {
        probationCatRepository.delete(probationCat);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isProbationCat(Long id) {
        return probationCatRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserCat getUserCat(Long id) {
        return userCatService.read(id);
    }
}

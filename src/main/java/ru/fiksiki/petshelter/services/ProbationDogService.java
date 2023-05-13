package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.model.UserDog;

import java.time.LocalDate;
import java.util.List;

public interface ProbationDogService {
    void create(ProbationDog probationDog);

    List<ProbationDog> readAll();

    ProbationDog read(long id);

    void updateLastReportDate(Long id, LocalDate localDate);

    void updateDayLeft(ProbationDog probationDog);

    List<Long> getAllAdopters();

    void deleteProbation(ProbationDog probationDog);

    boolean isProbationDog(Long id);

    UserDog getUserDog(Long id);
}

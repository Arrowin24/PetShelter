package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.ProbationCat;
import ru.fiksiki.petshelter.model.UserCat;


import java.time.LocalDate;
import java.util.List;

public interface ProbationCatService {
    void create(ProbationCat probationCat);

    List<ProbationCat> readAll();

    ProbationCat read(long id);

    void updateLastReportDate(Long id, LocalDate localDate);

    void updateDayLeft(ProbationCat probationCat);

    List<Long> getAllAdopters();

    void deleteProbation(ProbationCat probationCat);

    boolean isProbationCat(Long id);

    UserCat getUserCat(Long id);
}

package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.ProbationDog;

import java.util.List;

public interface ProbationService {
    void create(ProbationDog probationDog);

    List<Long> getAllAdopters();
}

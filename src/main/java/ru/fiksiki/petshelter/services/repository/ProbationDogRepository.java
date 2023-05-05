package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiksiki.petshelter.model.ProbationDog;

public interface ProbationDogRepository extends JpaRepository<ProbationDog, Long> {

}

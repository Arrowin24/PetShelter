package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.VolunteerDog;

@Repository
public interface VolunteerDogRepository extends JpaRepository<VolunteerDog, Long> {
}

package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.VolunteerCat;

@Repository
public interface VolunteerCatRepository extends JpaRepository<VolunteerCat, Long> {
}

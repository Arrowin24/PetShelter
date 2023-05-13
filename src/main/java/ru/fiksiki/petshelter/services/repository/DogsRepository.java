package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.Dog;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Long> {
}

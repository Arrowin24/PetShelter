package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.AdopterDog;

@Repository
public interface AdopterDogRepository extends JpaRepository<AdopterDog, Long> {
}

package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.UserDog;

@Repository
public interface UserDogRepository extends JpaRepository<UserDog, Long> {

}

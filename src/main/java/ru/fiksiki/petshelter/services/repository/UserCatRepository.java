package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiksiki.petshelter.model.UserCat;

@Repository
public interface UserCatRepository extends JpaRepository<UserCat, Long> {
}

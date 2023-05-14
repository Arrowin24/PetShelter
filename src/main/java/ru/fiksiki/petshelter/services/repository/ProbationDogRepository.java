package ru.fiksiki.petshelter.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.fiksiki.petshelter.model.ProbationDog;

import java.time.LocalDate;

public interface ProbationDogRepository extends JpaRepository<ProbationDog, Long> {
    @Transactional
    @Modifying
    @Query("update ProbationDog p set p.dayLeft = ?1 where p.id = ?2 ")
    void updateDayLeft(int dayLeft, long id);
    @Transactional
    @Modifying
    @Query("update ProbationDog p set p.lastReport = ?2 where p.id=?1")
    void updateLastReportBy(Long id,LocalDate lastReport);

}

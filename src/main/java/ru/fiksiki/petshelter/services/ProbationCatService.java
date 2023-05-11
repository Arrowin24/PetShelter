package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.ProbationCat;
import ru.fiksiki.petshelter.model.UserCat;


import java.time.LocalDate;
import java.util.List;

/**
 * A service interface for managing probation cats.
 */
public interface ProbationCatService {

    /**
     * Creates a new probation cat in the system.
     *
     * @param probationCat the probation cat to create
     */
    void create(ProbationCat probationCat);

    /**
     * Gets all probation cats objects in the database.
     *
     * @return a list of all probation cats
     */
    List<ProbationCat> readAll();

    /**
     * Gets a probation cat by its ID.
     *
     * @param id the ID of the probation cat to retrieve
     * @return the probation cat with the given ID
     */
    ProbationCat read(long id);

    /**
     * Updates the last report date for a probation cat.
     *
     * @param id        the ID of the probation cat to update
     * @param localDate the new last report date
     */
    void updateLastReportDate(Long id, LocalDate localDate);

    /**
     * Updates the remaining days of probation for a probation cat.
     *
     * @param probationCat the probation cat to update
     */
    void updateDayLeft(ProbationCat probationCat);

    /**
     * Gets the IDs of all users who have adopted a probation cat.
     *
     * @return a list of all user IDs who have adopted a probation cat
     */
    List<Long> getAllAdopters();

    /**
     * Deletes a probation cat from the system.
     *
     * @param probationCat the probation cat to delete
     */
    void deleteProbation(ProbationCat probationCat);

    /**
     * Checks if a probation cat with the given ID exists in the system.
     *
     * @param id the ID of the probation cat to check for
     * @return true if a probation cat with the given ID exists, false otherwise
     */
    boolean isProbationCat(Long id);

    /**
     * Gets the user cat associated with the given ID.
     *
     * @param id the ID of the user cat to retrieve
     * @return the user cat with the given ID
     */
    UserCat getUserCat(Long id);
}

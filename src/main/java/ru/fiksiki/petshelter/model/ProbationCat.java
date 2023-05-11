package ru.fiksiki.petshelter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Represents a probation for cat that is currently under the care of an adopter and a volunteer.
 */
@Entity
@Table(name = "probation_cat")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProbationCat {
    @Id
    @Column(name = "adopter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "volunteer_id") private long volunteerId;
    @Column(name = "last_rep") private LocalDate lastReport;
    @Column(name = "day_left") private int dayLeft;

}

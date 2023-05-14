package ru.fiksiki.petshelter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "probation_dog")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProbationDog {
    @Id
    @Column(name = "adopter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "volunteer_id") private long volunteerId;
    @Column(name = "last_rep") private LocalDate lastReport;
    @Column(name = "day_left") private int dayLeft;

}

package ru.fiksiki.petshelter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "probation_dog")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProbationDog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "adopter_id") private long adopterId;
    @Column(name = "volunteer_id") private long dogId;
    @Column(name = "day_left") private int dayLeft;

}

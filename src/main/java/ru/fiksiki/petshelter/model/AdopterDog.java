package ru.fiksiki.petshelter.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "adopter_dog")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdopterDog {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_id")
    private long userId;
    @Column(name="dog_id")
    private long dogId;
}

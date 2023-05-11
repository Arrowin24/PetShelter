package ru.fiksiki.petshelter.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "adopter_cat")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdopterCat {
    @Id
    @Column(name="adopter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="cat_id")
    private long catId;
}

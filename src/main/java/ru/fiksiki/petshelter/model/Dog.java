package ru.fiksiki.petshelter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="info")
    private String info;
}

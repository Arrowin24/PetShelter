package ru.fiksiki.petshelter.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_cat")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCat {
    @Id
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="mail")
    private String mail;
    @Column(name="phone")
    private String phone;

    public String toText() {
        return "������������� ������ �����/���� �  ID: " + id + "\n ���: " + name + "\n �������: "+phone;
    }
}

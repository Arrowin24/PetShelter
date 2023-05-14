package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.VolunteerCat;

import java.util.List;


public interface VolunteerCatService {

    List<VolunteerCat> getAll();

    void create(VolunteerCat volunteerCat);

    VolunteerCat read(long id);
}

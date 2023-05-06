package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.VolunteerDog;

import java.util.List;


public interface VolunteerDogService {

    List<VolunteerDog> getAll();

    void create(VolunteerDog volunteerDog);

    VolunteerDog read(long id);


}

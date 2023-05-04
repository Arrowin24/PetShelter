package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.VolunteerDog;


public interface VolunteerDogService {

    void create(VolunteerDog volunteerDog);

    VolunteerDog read(long id);


}

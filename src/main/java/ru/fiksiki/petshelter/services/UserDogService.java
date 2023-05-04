package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.UserDog;
import ru.fiksiki.petshelter.model.VolunteerDog;

public interface UserDogService {
    void create(UserDog userDog);

    UserDog read(long id);
}

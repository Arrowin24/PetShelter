package ru.fiksiki.petshelter.services;

import ru.fiksiki.petshelter.model.UserCat;
import ru.fiksiki.petshelter.model.VolunteerDog;

public interface UserCatService {
    void create(UserCat userCat);

    UserCat read(long id);

}

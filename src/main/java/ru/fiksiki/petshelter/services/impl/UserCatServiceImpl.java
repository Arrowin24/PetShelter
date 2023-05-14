package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.UserCatNotFoundException;
import ru.fiksiki.petshelter.exception.VolunteerNotFoundException;
import ru.fiksiki.petshelter.model.UserCat;
import ru.fiksiki.petshelter.services.UserCatService;
import ru.fiksiki.petshelter.services.repository.UserCatRepository;
@Service
public class UserCatServiceImpl implements UserCatService {

    private final UserCatRepository userCatRepository;

    public UserCatServiceImpl(UserCatRepository userCatRepository) {
        this.userCatRepository = userCatRepository;
    }

    @Override
    public void create(UserCat userCat) {
        userCatRepository.save(userCat);
    }

    @Override
    public UserCat read(long id) {
        if(userCatRepository.findById(id).isPresent()){
            return userCatRepository.findById(id).get();
        }
        throw new UserCatNotFoundException();
    }
}

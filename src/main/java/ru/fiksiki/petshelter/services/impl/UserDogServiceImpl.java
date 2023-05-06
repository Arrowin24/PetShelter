package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.UserDogNotFoundException;
import ru.fiksiki.petshelter.exception.VolunteerNotFoundException;
import ru.fiksiki.petshelter.model.UserDog;
import ru.fiksiki.petshelter.services.UserDogService;
import ru.fiksiki.petshelter.services.repository.UserDogRepository;
@Service
public class UserDogServiceImpl implements UserDogService {

    private final UserDogRepository userDogRepository;

    public UserDogServiceImpl(UserDogRepository userDogRepository) {
        this.userDogRepository = userDogRepository;
    }

    @Override
    public void create(UserDog userDog) {
        userDogRepository.save(userDog);
    }

    @Override
    public UserDog read(long id) {
        if(userDogRepository.findById(id).isPresent()){
            return userDogRepository.findById(id).get();
        }
        throw new UserDogNotFoundException();
    }
}

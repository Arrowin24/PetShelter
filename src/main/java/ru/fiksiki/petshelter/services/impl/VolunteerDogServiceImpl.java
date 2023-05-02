package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.VolunteerNotFoundException;
import ru.fiksiki.petshelter.model.VolunteerDog;
import ru.fiksiki.petshelter.services.VolunteerDogService;
import ru.fiksiki.petshelter.services.repository.VolunteerDogRepository;

import java.util.List;

@Service
public class VolunteerDogServiceImpl implements VolunteerDogService {

    private final VolunteerDogRepository volunteerRepository;

    public VolunteerDogServiceImpl(VolunteerDogRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public List<VolunteerDog> getAll() {
       //return volunteerRepository.findAll();
        VolunteerDog anton = new VolunteerDog();
        anton.setId(420046312);
        return List.of(anton);
    }

    @Override
    public void create(VolunteerDog volunteerDog){
        volunteerRepository.save(volunteerDog);
    }

    @Override
    public VolunteerDog read(long id){
        if(volunteerRepository.findById(id).isPresent()){
            return volunteerRepository.findById(id).get();
        }
        throw new VolunteerNotFoundException();
    }

}

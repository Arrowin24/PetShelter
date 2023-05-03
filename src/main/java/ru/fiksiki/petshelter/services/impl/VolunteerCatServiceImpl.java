package ru.fiksiki.petshelter.services.impl;

import org.springframework.stereotype.Service;
import ru.fiksiki.petshelter.exception.VolunteerNotFoundException;
import ru.fiksiki.petshelter.model.VolunteerCat;
import ru.fiksiki.petshelter.services.VolunteerCatService;
import ru.fiksiki.petshelter.services.repository.VolunteerCatRepository;

import java.util.List;

@Service
public class VolunteerCatServiceImpl implements VolunteerCatService {

    private final VolunteerCatRepository volunteerRepository;

    public VolunteerCatServiceImpl(VolunteerCatRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public List<VolunteerCat> getAll() {
       //return volunteerRepository.findAll();
        VolunteerCat anton = new VolunteerCat();
        anton.setId(420046312);
        return List.of(anton);
    }

    @Override
    public void create(VolunteerCat volunteerCat){
        volunteerRepository.save(volunteerCat);
    }

    @Override
    public VolunteerCat read(long id){
        if(volunteerRepository.findById(id).isPresent()){
            return volunteerRepository.findById(id).get();
        }
        throw new VolunteerNotFoundException();
    }

}

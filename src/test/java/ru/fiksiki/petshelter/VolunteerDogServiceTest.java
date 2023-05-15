package ru.fiksiki.petshelter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.fiksiki.petshelter.model.VolunteerDog;
import ru.fiksiki.petshelter.services.impl.VolunteerDogServiceImpl;
import ru.fiksiki.petshelter.services.repository.VolunteerDogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * This class allows to test the VolunteerDogService
 */
@DisplayName("Unit test for the VolunteerDogService")
public class VolunteerDogServiceTest {
    @Mock
    VolunteerDogRepository volunteerDogRepository;

    @InjectMocks
    VolunteerDogServiceImpl volunteerDogService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    /**
     * this test checks that method read(long id) returns correct value from repository
     */
    @Test
    public void readTest() {
        VolunteerDog expectedVolunteer = new VolunteerDog(1, "test", "test@test.com", "111");
        when(volunteerDogRepository.findById(1L)).thenReturn(Optional.of(expectedVolunteer));

        VolunteerDog actualVolunteer = volunteerDogService.read(1L);
        Assertions.assertNotNull(actualVolunteer);
        Assertions.assertEquals(expectedVolunteer,actualVolunteer);
    }
    /**
     * this test checks that method getAll() returns correct values from repository
     */
    @Test
    public void getAllTest() {
        List<VolunteerDog> volunteers = new ArrayList<>();
        VolunteerDog volunteerDog1= new VolunteerDog(1, "test", "test@test.com", "111");
        VolunteerDog volunteerDog2= new VolunteerDog(2, "test", "test@test.com", "222");
        volunteers.add(volunteerDog1);
        volunteers.add(volunteerDog2);

        when(volunteerDogRepository.findAll()).thenReturn(volunteers);

        List<VolunteerDog> actualVolunteers = volunteerDogService.getAll();

        Assertions.assertNotNull(actualVolunteers);
        Assertions.assertEquals(volunteers.get(0), actualVolunteers.get(0));
    }

}

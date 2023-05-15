package ru.fiksiki.petshelter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.fiksiki.petshelter.model.VolunteerCat;
import ru.fiksiki.petshelter.services.impl.VolunteerCatServiceImpl;
import ru.fiksiki.petshelter.services.repository.VolunteerCatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * This class allows to test the VolunteerCatService
 */
@DisplayName("Unit test for the VolunteerCatService")
public class VolunteerCatServiceTest {
    @Mock
    VolunteerCatRepository volunteerCatRepository ;

    @InjectMocks
    VolunteerCatServiceImpl volunteerCatService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    /**
     * this test checks that method read(long id) returns correct value from repository
     */
    @Test
    public void readTest() {
        VolunteerCat expectedVolunteer = new VolunteerCat(1, "test", "test@test.com", "111");
        when(volunteerCatRepository.findById(1L)).thenReturn(Optional.of(expectedVolunteer));

        VolunteerCat actualVolunteer = volunteerCatService.read(1L);
        Assertions.assertNotNull(actualVolunteer);
        Assertions.assertEquals(expectedVolunteer,actualVolunteer);
    }
    /**
     * this test checks that method getAll() returns correct values from repository
     */
    @Test
    public void getAllTest() {
        List<VolunteerCat> volunteers = new ArrayList<>();
        VolunteerCat volunteerCat1= new VolunteerCat(1, "test", "test@test.com", "111");
        VolunteerCat volunteerCat2= new VolunteerCat(2, "test", "test@test.com", "222");
        volunteers.add(volunteerCat1);
        volunteers.add(volunteerCat2);

        when(volunteerCatRepository.findAll()).thenReturn(volunteers);

        List<VolunteerCat> actualVolunteers = volunteerCatService.getAll();

        Assertions.assertNotNull(actualVolunteers);
        Assertions.assertEquals(volunteers.get(0), actualVolunteers.get(0));
    }

}

package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import lt.sdacademy.university.repositories.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniversityServiceTest {

    private UniversityService universityService;

    @BeforeEach
    public void init() {
        universityService = new UniversityService(mock(UniversityRepository.class));
    }

    @Test
    void getUniversities_isNotEmpty() {
        assertFalse(universityService.getUniversities().isEmpty());
    }
}

package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import lt.sdacademy.university.models.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.services.UniversityService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Tag("integration")
@Transactional
class UniversityServiceIT {

    @Autowired
    private UniversityService universityService;

    @Test
    void getUniversitiesWithStudyPrograms() {
        List<UniversityEntity> universities = universityService.getUniversities();

        assertFalse(universities.isEmpty());
    }
}

package lt.sdacademy.university.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import lt.sdacademy.university.AbstractIntegration;
import lt.sdacademy.university.model.dto.University;
import lt.sdacademy.university.model.entity.UniversityEntity;
import lt.sdacademy.university.repository.UniversityRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("integration")
class UniversityControllerIT extends AbstractIntegration {

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    void getAll() throws Exception {
        List<UniversityEntity> existingUniversities = universityRepository.findAll();
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setCode("TEST");
        universityEntity.setTitle("Test University");
        universityRepository.save(universityEntity);

        List<University> result = sendGet("/api/universities", new TypeReference<List<University>>() {
        });

        assertEquals(existingUniversities.size() + 1, result.size());
    }

    @Test
    void getUniversity() {
        // Prepare uni
        // Save it

        // Retrieve by id

        // Verify fields including studyProgram
    }
}

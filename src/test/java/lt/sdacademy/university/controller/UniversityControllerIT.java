package lt.sdacademy.university.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import lt.sdacademy.university.AbstractIntegration;
import lt.sdacademy.university.model.dto.Token;
import lt.sdacademy.university.model.dto.University;
import lt.sdacademy.university.model.dto.User;
import lt.sdacademy.university.model.entity.UniversityEntity;
import lt.sdacademy.university.model.entity.UserEntity;
import lt.sdacademy.university.repository.UniversityRepository;
import lt.sdacademy.university.repository.UserRepository;
import lt.sdacademy.university.service.SecurityService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("integration")
class UniversityControllerIT extends AbstractIntegration {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private SecurityService securityService;

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
    void getUniversity() throws Exception {
        User user = new User(null, "Name", "test@test.com");
        user.setPassword("testPassword");
        user = securityService.signUp(user);
        String token = securityService.generateToken(user.getId(), user.getEmail());
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setCode("TEST");
        universityEntity.setTitle("Test University");
        universityRepository.save(universityEntity);

        University university = sendGet("/api/universities/" + universityEntity.getId(), token, new TypeReference<University>() {
        });

        assertNotNull(university.getId());
    }
}

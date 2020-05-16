package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityConverter universityConverter;
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityConverter universityConverter, UniversityRepository universityRepository) {
        this.universityConverter = universityConverter;
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        List<UniversityEntity> universities = universityRepository.findAll();

        return universityConverter.convert(universities);
    }

    public University getUniversity(Integer id) {
        // TODO: fix
        return null;
    }

    public University save(University university) {
        UniversityEntity universityEntity = universityConverter.convertToEntity(university);
        UniversityEntity result = universityRepository.save(universityEntity);

        return universityConverter.convert(result);
    }

    public void delete(Integer id) {
        // TODO: fix
    }
}

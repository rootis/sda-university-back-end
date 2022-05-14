package lt.sdacademy.university.service;

import java.util.List;
import lt.sdacademy.university.converter.UniversityConverter;
import lt.sdacademy.university.model.dto.University;
import lt.sdacademy.university.model.entity.UniversityEntity;
import lt.sdacademy.university.repository.UniversityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public University getUniversity(Long id) {
        UniversityEntity universityEntity = universityRepository.findOneById(id);

        return universityConverter.convert(universityEntity);
    }

    public University save(University university) {
        UniversityEntity universityEntity = universityConverter.convertToEntity(university);
        UniversityEntity result = universityRepository.save(universityEntity);

        return universityConverter.convert(result);
    }

    @Transactional
    public void delete(Long id) {
        universityRepository.deleteOneById(id);
    }
}

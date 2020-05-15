package lt.sdacademy.university.services;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        List<UniversityEntity> universities = universityRepository.findAll();

        return universities.stream().map(University::convertFrom).collect(toList());
    }

    public University getUniversity(Integer id) {
        // TODO: fix
        return null;
    }

    public University save(University university) {
        // TODO: fix
        return university;
    }

    public void delete(Integer id) {
        // TODO: fix
    }
}

package lt.sdacademy.university.converters;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityConverter {

    private final UniversityRepository universityRepository;

    public UniversityConverter(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> convert(List<UniversityEntity> universities) {
        return universities.stream().map(this::convert).collect(toList());
    }

    public University convert(UniversityEntity university) {
        List<String> studyPrograms = university.getStudyPrograms().stream().map(s -> s.getTitle()).collect(toList());

        return new University(
            university.getId(),
            university.getCode(),
            university.getTitle(),
            studyPrograms
        );
    }

    public UniversityEntity convertToEntity(University university) {
        UniversityEntity result;
        if (university.getId() == null) {
            result = new UniversityEntity();
        } else {
            result = universityRepository.findOneById(university.getId());
        }
        result.setCode(university.getCode());
        result.setTitle(university.getTitle());

        return result;
    }
}

package lt.sdacademy.university.services;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final StudyProgramService studyProgramService;

    private final UniversityRepository universityRepository;

    public UniversityService(StudyProgramService studyProgramService, UniversityRepository universityRepository) {
        this.studyProgramService = studyProgramService;
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

    public List<University> getUniversitiesWithStudyPrograms() {
        List<StudyProgram> studyPrograms = studyProgramService.getStudyPrograms();

        // TODO: add study programs to universities

        return null;
    }
}

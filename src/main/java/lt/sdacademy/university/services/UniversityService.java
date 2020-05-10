package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.StudyProgram;
import lt.sdacademy.university.models.University;
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

    public List<UniversityEntity> getUniversities() {
        return universityRepository.findAll();
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

package lt.sdacademy.university.services;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.StudyProgram;
import lt.sdacademy.university.models.University;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final StudyProgramService studyProgramService;

    public UniversityService(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    public List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        universities.add(new University(1, "KTU"));
        universities.add(new University(2, "SDA"));

        return universities;
    }

    public University getUniversity(Integer id) {
        return getUniversities().stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public List<University> getUniversitiesWithStudyPrograms() {
        List<University> universities = getUniversities();
        List<StudyProgram> studyPrograms = studyProgramService.getStudyPrograms();

        // TODO: add study programs to universities

        return universities;
    }
}

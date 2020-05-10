package lt.sdacademy.university.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lt.sdacademy.university.models.StudyProgram;
import lt.sdacademy.university.models.University;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final StudyProgramService studyProgramService;

    List<University> universities = new ArrayList<>(Arrays.asList(new University(1, "KTU"), new University(2, "SDA")));

    public UniversityService(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public University getUniversity(Integer id) {
        return universities.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public University save(University university) {
        return university.getId() == null ? create(university) : update(university);
    }

    public void delete(Integer id) {
        universities.removeIf(u -> u.getId().equals(id));
    }

    public List<University> getUniversitiesWithStudyPrograms() {
        List<StudyProgram> studyPrograms = studyProgramService.getStudyPrograms();

        // TODO: add study programs to universities

        return universities;
    }

    private University create(University university) {
        Integer maxId = universities.stream().map(u -> u.getId()).sorted(Comparator.reverseOrder()).findFirst().orElse(0);
        university.setId(maxId + 1);

        universities.add(university);

        return university;
    }

    private University update(University university) {
        // TODO: find in list university with the same id and change it

        return university;
    }

}

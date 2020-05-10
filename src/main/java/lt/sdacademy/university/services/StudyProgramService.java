package lt.sdacademy.university.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import org.springframework.stereotype.Service;

@Service
public class StudyProgramService {

    private final ModuleService moduleService;

    private List<StudyProgram> studyPrograms = new ArrayList<>(
        Arrays.asList(
            new StudyProgram(1, "Computer Science", 1),
            new StudyProgram(2, "Java", 2)
        )
    );

    public StudyProgramService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public List<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public StudyProgram getStudyProgram(Integer id) {
        return studyPrograms.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Integer id) {
        studyPrograms.removeIf(sp -> sp.getId().equals(id));
    }

    public StudyProgram save(StudyProgram studyProgram) {
        studyPrograms.add(studyProgram);

        return studyProgram;
    }

    public List<StudyProgram> getStudyProgramsWithModules() {
        // TODO: implement
        // moduleService.getModules();
        return getStudyPrograms();
    }
}

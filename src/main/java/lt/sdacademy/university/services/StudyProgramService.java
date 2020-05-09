package lt.sdacademy.university.services;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.StudyProgram;
import org.springframework.stereotype.Service;

@Service
public class StudyProgramService {

    public List<StudyProgram> getStudyPrograms() {
        List<StudyProgram> studyPrograms = new ArrayList<>();
        studyPrograms.add(new StudyProgram(1, "Computer Science", 1));
        studyPrograms.add(new StudyProgram(2, "Java", 2));

        return studyPrograms;
    }

    public List<StudyProgram> getStudyProgramsWithModules() {
        // TODO: implement
        // moduleService.getModules();
        return getStudyPrograms();
    }
}

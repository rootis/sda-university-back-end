package lt.sdacademy.university.tasks.fundamentals;

import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;

public class StudyProgramService {

    public StudyProgram getStudyProgram() {
        return new StudyProgram();
    }

    public StudyProgram getStudyProgramWithTitle(String title) {
        return null;
    }

    public StudyProgram getStudyProgramWithIdAndTitle(Integer id, String title) {
        return null;
    }

    public StudyProgram getStudyProgramWithModule(String moduleTitle) {
        return null;
    }

    public List<StudyProgram> getStudyPrograms(String... titles) {
        return null;
    }

    public StudyProgram getStudyProgramWithModules(String... moduleTitles) {
        return null;
    }

    public StudyProgram getLastStudyProgram(StudyProgram... studyPrograms) {
        return null;
    }

    public String getLongestModuleTitle(StudyProgram studyProgram) {
        return null;
    }
}

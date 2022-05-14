package lt.sdacademy.university.converter;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lt.sdacademy.university.model.dto.StudyProgram;
import lt.sdacademy.university.model.entity.ModuleEntity;
import lt.sdacademy.university.model.entity.StudyProgramEntity;
import org.springframework.stereotype.Component;

@Component
public class StudyProgramConverter {

    public List<StudyProgram> convert(List<StudyProgramEntity> studyPrograms) {
        if (studyPrograms == null) {
            return null;
        }

        return studyPrograms.stream().map(this::convert).collect(toList());
    }

    public StudyProgram convert(StudyProgramEntity studyProgram) {
        List<String> moduleTitles = studyProgram.getModules().stream().map(ModuleEntity::getTitle).collect(toList());

        return new StudyProgram(
            studyProgram.getId(),
            studyProgram.getTitle(),
            moduleTitles
        );
    }
}

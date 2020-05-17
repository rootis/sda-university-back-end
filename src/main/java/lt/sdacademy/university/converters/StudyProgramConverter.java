package lt.sdacademy.university.converters;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.stereotype.Component;

@Component
public class StudyProgramConverter {

    public List<StudyProgram> convert(List<StudyProgramEntity> studyPrograms) {
        // TODO: fix
        return new ArrayList<>();
    }
}

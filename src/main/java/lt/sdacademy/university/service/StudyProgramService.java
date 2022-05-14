package lt.sdacademy.university.service;

import java.util.List;
import lt.sdacademy.university.converter.StudyProgramConverter;
import lt.sdacademy.university.model.dto.StudyProgram;
import lt.sdacademy.university.model.entity.StudyProgramEntity;
import lt.sdacademy.university.repository.StudyProgramRepository;
import org.springframework.stereotype.Service;

@Service
public class StudyProgramService {

    private final StudyProgramConverter studyProgramConverter;
    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramService(StudyProgramConverter studyProgramConverter, StudyProgramRepository studyProgramRepository) {
        this.studyProgramConverter = studyProgramConverter;
        this.studyProgramRepository = studyProgramRepository;
    }

    public List<StudyProgram> getStudyPrograms(String title) {
        List<StudyProgramEntity> studyPrograms = studyProgramRepository.findAllByModuleTitleLike(title);

        return studyProgramConverter.convert(studyPrograms);
    }
}

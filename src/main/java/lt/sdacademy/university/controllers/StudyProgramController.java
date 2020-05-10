package lt.sdacademy.university.controllers;

import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.services.StudyProgramService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-programs")
public class StudyProgramController {

    private final StudyProgramService studyProgramService;

    public StudyProgramController(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping
    public List<StudyProgram> getAll() {
        return studyProgramService.getStudyPrograms();
    }

    @GetMapping("/{id}")
    public StudyProgram getStudyProgram(@PathVariable Integer id) {
        return studyProgramService.getStudyProgram(id);
    }

    @PostMapping
    public StudyProgram save(@RequestBody StudyProgram studyProgram) {
        return studyProgramService.save(studyProgram);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studyProgramService.delete(id);
    }
}

package lt.sdacademy.university.models.dto;

import java.util.ArrayList;
import java.util.List;

public class University {

    private Integer id;

    private String code;

    private String title;

    private List<StudyProgram> studyPrograms = new ArrayList<>();

    public University() {
    }

    public University(Integer id, String code, String title, List<StudyProgram> studyPrograms) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.studyPrograms = studyPrograms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgram> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}

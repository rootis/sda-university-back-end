package lt.sdacademy.university.models;

public class StudyProgram {

    private Integer id;

    private String title;

    private Integer universityId;

    public StudyProgram(Integer id, String title, Integer universityId) {
        this.id = id;
        this.title = title;
        this.universityId = universityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }
}

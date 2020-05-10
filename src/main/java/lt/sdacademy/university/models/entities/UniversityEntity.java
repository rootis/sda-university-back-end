package lt.sdacademy.university.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class UniversityEntity extends AbstractEntity {

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "title", length = 250, nullable = false)
    private String title;

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
}

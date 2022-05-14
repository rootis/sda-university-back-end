package lt.sdacademy.university.repository;

import java.util.List;
import lt.sdacademy.university.model.entity.StudyProgramEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface StudyProgramRepository extends Repository<StudyProgramEntity, Long> {

    @Query("select s from StudyProgramEntity s join s.modules m where m.title like concat('%', :moduleTitle, '%')")
    List<StudyProgramEntity> findAllByModuleTitleLike(String moduleTitle);
}

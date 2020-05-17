package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface StudyProgramRepository extends Repository<StudyProgramEntity, Integer> {

    @Query("select s from StudyProgramEntity s join s.modules m where m.title like concat('%', :title, '%')")
    List<StudyProgramEntity> findAllByModuleTitleLike(String moduleTitle);

    // Task for Andrius: select study programs which has less than X modules (x is query parameter)


}

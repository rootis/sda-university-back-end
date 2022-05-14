package lt.sdacademy.university.repository;

import java.util.List;
import lt.sdacademy.university.model.entity.UniversityEntity;
import org.springframework.data.repository.Repository;

public interface UniversityRepository extends Repository<UniversityEntity, Long> {

    UniversityEntity findOneById(Long id);

    boolean existsByCode(String code);

    List<UniversityEntity> findAll();

    UniversityEntity save(UniversityEntity university);

    void deleteOneById(Long id);
}

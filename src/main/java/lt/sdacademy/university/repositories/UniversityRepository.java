package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.data.repository.Repository;

public interface UniversityRepository extends Repository<UniversityEntity, Integer> {

    List<UniversityEntity> findAll();
}

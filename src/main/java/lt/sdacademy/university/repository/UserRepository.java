package lt.sdacademy.university.repository;

import lt.sdacademy.university.model.entity.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity findOneByEmail(String email);

    UserEntity save(UserEntity user);
}

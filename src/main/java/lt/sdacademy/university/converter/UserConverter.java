package lt.sdacademy.university.converter;

import lt.sdacademy.university.model.dto.User;
import lt.sdacademy.university.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convert(User user) {
        if (user == null) {
            return null;
        }

        UserEntity result = new UserEntity();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setEmail(user.getEmail());

        return result;
    }

    public User convert(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getUsername());
    }
}

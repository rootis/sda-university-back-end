package lt.sdacademy.university.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import lt.sdacademy.university.config.JwtAuthFilter;
import lt.sdacademy.university.converter.UserConverter;
import lt.sdacademy.university.model.dto.User;
import lt.sdacademy.university.model.entity.UserEntity;
import lt.sdacademy.university.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public SecurityService(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findOneByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User \"%s\" not found", username));
        }

        return user;
    }

    public User signUp(User user) {
        UserEntity userEntity = userConverter.convert(user);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        UserEntity result = userRepository.save(userEntity);

        return userConverter.convert(result);
    }

    public String generateToken(Long id, String username) {
        return Jwts.builder()
            .setClaims(new HashMap<>())
            .setId(id.toString())
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JwtAuthFilter.VALIDITY))
            .signWith(SignatureAlgorithm.HS512, JwtAuthFilter.SECRET)
            .compact();
    }
}

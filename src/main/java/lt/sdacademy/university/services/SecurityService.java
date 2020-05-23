package lt.sdacademy.university.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lt.sdacademy.university.configs.JwtAuthFilter;
import lt.sdacademy.university.models.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = new UserEntity();
        user.setEmail(username);
        user.setPassword(new BCryptPasswordEncoder().encode("slaptas"));

        return user;
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("subject", username);

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JwtAuthFilter.VALIDITY))
            .signWith(SignatureAlgorithm.HS512, JwtAuthFilter.SECRET)
            .compact();
    }
}

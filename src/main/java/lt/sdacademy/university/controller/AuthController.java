package lt.sdacademy.university.controller;

import lt.sdacademy.university.model.dto.Token;
import lt.sdacademy.university.model.dto.User;
import lt.sdacademy.university.model.entity.UserEntity;
import lt.sdacademy.university.service.SecurityService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final SecurityService securityService;

    public AuthController(AuthenticationManager authenticationManager, SecurityService securityService) {
        this.authenticationManager = authenticationManager;
        this.securityService = securityService;
    }

    @PostMapping("/login")
    public Token authenticate(@RequestBody User user) {
        UserEntity userEntity = securityService.loadUserByUsername(user.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity, user.getPassword()));

        return new Token(securityService.generateToken(userEntity.getId(), userEntity.getEmail()));
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user) {
        return securityService.signUp(user);
    }
}

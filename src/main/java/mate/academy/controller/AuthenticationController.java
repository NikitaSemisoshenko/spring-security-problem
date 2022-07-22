package mate.academy.controller;

import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.model.User;
import mate.academy.model.dto.UserLoginDto;
import mate.academy.model.dto.UserRegistrationDto;
import mate.academy.security.AuthenticationService;
import mate.academy.security.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRegistrationDto dto) {
        authenticationService.register(dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto dto) {
        User user = authenticationService.login(dto.getEmail(), dto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles()
                .stream()
                .map(x -> x.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}

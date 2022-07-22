package mate.academy.controller;

import java.net.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String hello(Authentication authentication, HttpServletRequest request) {
        return String.format("Hello, %s. Your session id is — %s", authentication.getName(), request.getSession().getId());
    }
}

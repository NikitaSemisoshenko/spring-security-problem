package mate.academy.security;

import java.util.Set;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.RoleService;
import mate.academy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void register(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles(Set.of(roleService.getByName("USER")));
        userService.save(user);
    }

    @Override
    public User login(String login, String password) {
        User user = userService.findByEmail(login).orElseThrow(() ->
                new RuntimeException("Something wrong with login"));
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Something wrong with passwords");
    }
}

package mate.academy.config;

import javax.annotation.PostConstruct;
import mate.academy.model.Role;
import mate.academy.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;

    public DataInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role user = new Role(Role.RoleName.USER);
        Role admin = new Role(Role.RoleName.ADMIN);
        roleService.save(user);
        roleService.save(admin);
    }
}

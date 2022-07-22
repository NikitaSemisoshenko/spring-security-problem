package mate.academy.dao;

import mate.academy.model.Role;

public interface RoleDao {
    Role save(Role role);

    Role getByName(String roleName);
}

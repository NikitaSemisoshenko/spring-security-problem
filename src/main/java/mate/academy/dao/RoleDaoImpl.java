package mate.academy.dao;

import mate.academy.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory factory;

    public RoleDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Role save(Role role) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException();
        }
    }

    @Override
    public Role getByName(String roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery(
                    "from Role r " +
                            "where r.roleName = :name", Role.class)
                    .setParameter("name", Role.RoleName.valueOf(roleName))
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

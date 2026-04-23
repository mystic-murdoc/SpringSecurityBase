package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findByName(String name) {
        List<Role> roles = entityManager.createQuery(
                        "from Role where name = :name", Role.class)
                .setParameter("name", name)
                .getResultList();

        return roles.isEmpty() ? null : roles.get(0);
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }
}

package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
        try {
            return entityManager.createQuery(
                            "from User where username = :username", User.class)
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Role findRoleByName(String name) {
        return entityManager.createQuery(
                "from Role where name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}

package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findUserById(Long id);
    User findUserByUsername(String username);
    Role findRoleByName(String name);
}

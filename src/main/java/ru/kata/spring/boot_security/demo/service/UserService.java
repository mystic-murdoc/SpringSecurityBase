package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    void saveUser(User user, String roleName);
    void updateUser(User user, String roleName);
    void deleteUser(Long id);
    Optional<User> findUserByUsername(String username);
    User findUserById(Long id);
}

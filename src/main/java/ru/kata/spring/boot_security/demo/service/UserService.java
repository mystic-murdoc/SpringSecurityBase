package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findUserByUsername(String username);
    User findUserById(Long id);
}

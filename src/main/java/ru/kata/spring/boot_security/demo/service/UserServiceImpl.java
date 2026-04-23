package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = userDao.findUserById(user.getId());

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setUsername(user.getUsername());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }

        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            existingUser.setRoles(user.getRoles());
        }

        userDao.updateUser(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }
}

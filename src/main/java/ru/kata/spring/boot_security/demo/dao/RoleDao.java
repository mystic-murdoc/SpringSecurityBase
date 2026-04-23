package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;

@Repository
public interface RoleDao {
    Role findByName(String name);
    void save(Role role);
}

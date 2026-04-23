package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.Role;

@Service
public interface RoleService {
    Role findByName(String name);
    void save(Role role);
}

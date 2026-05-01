package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user",
                userService.findUserById(id));
        return "admin/edit";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user,
                             @RequestParam String roleName) {
        userService.saveUser(user, roleName);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable Long id,
                           @ModelAttribute User user,
                             @RequestParam String roleName) {
        user.setId(id);
        userService.updateUser(user, roleName);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}

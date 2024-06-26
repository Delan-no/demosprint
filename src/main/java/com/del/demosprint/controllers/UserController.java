package com.del.demosprint.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.del.demosprint.models.User;
import com.del.demosprint.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    // Injection du service UserService
    @Autowired
    private UserService userService;

    // Méthode pour obtenir tous les utilisateurs
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Méthode pour ajouter un utilisateur
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Méthode pour supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setLastName(updatedUser.getLastName());
            user.setMail(updatedUser.getMail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return userService.addUser(user);
        } else {
            return null;
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            session.setAttribute("user", authenticatedUser);
            return "Login successful";
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}


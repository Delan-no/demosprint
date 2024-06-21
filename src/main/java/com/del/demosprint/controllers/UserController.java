package com.del.demosprint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.del.demosprint.models.User;
import com.del.demosprint.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
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
}

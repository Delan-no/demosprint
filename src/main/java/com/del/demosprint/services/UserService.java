package com.del.demosprint.services;

import com.del.demosprint.models.User;
import com.del.demosprint.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Méthode pour obtenir tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter un utilisateur
    @PostMapping
    public User addUser(User user) {
        // System.out.println(user);
        return userRepository.save(user);
    }
}

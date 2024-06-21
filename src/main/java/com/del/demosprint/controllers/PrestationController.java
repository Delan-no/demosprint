package com.del.demosprint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.del.demosprint.models.Prestation;
import com.del.demosprint.services.PrestationService;

@RestController
@RequestMapping("/api/prestations")
public class PrestationController {
    // Injection du service prestationService
    @Autowired
    private PrestationService prestationService;

    // Méthode pour obtenir tous les utilisateurs
    @GetMapping
    public List<Prestation> getAllPrestations() {
        return prestationService.getAllPrestations();
    }

    @GetMapping("/{id}")
    public Prestation getPrestationById(@PathVariable Long id) {
        return prestationService.getAllPrestationById(id);
    }   
    
    // Méthode pour ajouter un utilisateur
    @PostMapping
    public Prestation addPrestation(@RequestBody Prestation prestation) {
        return prestationService.addPrestation(prestation);
    }
}

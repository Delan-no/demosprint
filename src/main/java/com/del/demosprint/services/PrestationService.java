package com.del.demosprint.services;

import com.del.demosprint.models.Prestation;
import com.del.demosprint.repositories.PrestationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Service;

@Service
public class PrestationService {
    @Autowired
    private PrestationRepository prestationRepository;

    // Méthode pour obtenir tous les utilisateurs
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }

    public Prestation getAllPrestationById(Long id) {
        return prestationRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter un utilisateur
    @PostMapping
    public Prestation addPrestation(Prestation prestation) {
        return prestationRepository.save(prestation);
    }
}

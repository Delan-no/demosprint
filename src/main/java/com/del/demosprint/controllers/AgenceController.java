package com.del.demosprint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.del.demosprint.models.Agence;
import com.del.demosprint.services.AgenceService;

@RestController

// Annotation pour définir le chemin de base pour toutes les routes dans ce
// controller
@RequestMapping("/api/agencies")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    @GetMapping
    public List<Agence> getAllAgencies() {
        System.out.println("Délannoooo agencies...");
        return agenceService.getAllAgencies();
    }

}

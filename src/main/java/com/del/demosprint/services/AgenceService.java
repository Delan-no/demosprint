package com.del.demosprint.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.del.demosprint.models.Agence;
import com.del.demosprint.repositories.AgenceRepository;

import java.util.List;

@Service
public class AgenceService {
    private static final Logger logger = LoggerFactory.getLogger(AgenceService.class);
    @Autowired
    private AgenceRepository agenceRepository;

    public List<Agence> getAllAgencies() {
        logger.info("Fetching all agencies from the database");
        List<Agence> agencies = agenceRepository.findAll();
        logger.info("Fetched {} agencies", agencies.size());
        return agencies;
    }
}

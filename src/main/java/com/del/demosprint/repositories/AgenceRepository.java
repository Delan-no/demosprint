package com.del.demosprint.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.del.demosprint.models.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}


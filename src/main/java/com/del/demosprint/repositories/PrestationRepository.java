package com.del.demosprint.repositories;
import com.del.demosprint.models.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// PrestationRepository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
}

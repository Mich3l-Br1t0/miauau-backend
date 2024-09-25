package com.miauau.app.repositories;

import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdoptionCandidateRepository extends JpaRepository<AdoptionCandidateEntity, UUID> {
}

package com.miauau.app.repositories;

import com.miauau.app.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<AnimalEntity, UUID> {
}

package com.miauau.app.repository;

import com.miauau.app.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<AnimalEntity, UUID> {
}

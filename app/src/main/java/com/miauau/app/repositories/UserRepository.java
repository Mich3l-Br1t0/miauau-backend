package com.miauau.app.repositories;

import com.miauau.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findByEmail(String email);
}

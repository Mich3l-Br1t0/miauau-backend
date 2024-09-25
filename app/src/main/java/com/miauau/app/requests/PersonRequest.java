package com.miauau.app.requests;

import com.miauau.app.entities.AddressEntity;
import com.miauau.app.entities.OccupationEntity;

import java.time.LocalDateTime;

public record PersonRequest(
        String name,
        LocalDateTime dateOfBirth,
        String rg,
        String cpf,
        String phone,
        String landline,
        String email,
        String profession,
        OccupationEntity occupation,
        AddressEntity address
) {
}
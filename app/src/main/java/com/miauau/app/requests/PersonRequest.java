package com.miauau.app.requests;

import java.time.LocalDateTime;

public record PersonRequest(
        String name,
        LocalDateTime dateOfBirth,
        String rg,
        String cpf,
        String phone,
        String landline,
        String email,
        String profession
) {
}
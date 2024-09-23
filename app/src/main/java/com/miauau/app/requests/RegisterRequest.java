package com.miauau.app.requests;

import com.miauau.app.enums.UserRole;

public record RegisterRequest(
    String login,
    String password,
    UserRole role
) {
}

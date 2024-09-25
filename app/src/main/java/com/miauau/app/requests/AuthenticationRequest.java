package com.miauau.app.requests;

public record AuthenticationRequest(
    String login,
    String password
) {
}

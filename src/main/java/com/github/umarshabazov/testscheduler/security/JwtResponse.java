package com.github.umarshabazov.testscheduler.security;

public class JwtResponse {

    private final String jwtToken;

    // Конструктор
    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // Геттер для токена
    public String getJwtToken() {
        return jwtToken;
    }
}

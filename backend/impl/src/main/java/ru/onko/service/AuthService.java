package ru.onko.service;

import ru.onko.dto.response.AuthResponse;

import java.util.UUID;

public interface AuthService {

    AuthResponse authenticate(UUID refreshToken);
}

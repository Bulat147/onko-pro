package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.AuthApi;
import ru.onko.dto.response.AuthResponse;
import ru.onko.security.util.AuthUtil;
import ru.onko.service.AuthService;
import ru.onko.service.RefreshTokenService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    private final RefreshTokenService refreshTokenService;

    private final AuthUtil authUtil;

    @Override
    public ResponseEntity<AuthResponse> authenticate(UUID refreshToken) {
        AuthResponse response = authService.authenticate(refreshToken);
        return ResponseEntity.ok(response);
    }
}

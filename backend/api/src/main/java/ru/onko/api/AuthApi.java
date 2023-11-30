package ru.onko.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.onko.dto.response.AuthResponse;

import java.util.UUID;

@RequestMapping("/auth")
public interface AuthApi {

    @GetMapping("/{refresh-token}")
    ResponseEntity<AuthResponse> authenticate(@PathVariable("refresh-token")UUID refreshToken);
}

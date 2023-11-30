package ru.onko.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import ru.onko.dto.response.AuthResponse;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;
import ru.onko.security.util.JwtUtil;
import ru.onko.service.AccountService;
import ru.onko.service.AuthService;
import ru.onko.service.RefreshTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

import static ru.onko.security.util.JwtUtil.REFRESH_TOKEN_EXPIRE_DAYS;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final RefreshTokenService refreshTokenService;

    private final JwtUtil jwtUtil;

    private final AccountService accountService;

    @Override
    public AuthResponse authenticate(UUID refreshToken) {
        RefreshTokenEntity token = refreshTokenService.findTokenByName(refreshToken)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid refresh token"));

        LocalDateTime expire = token.getExpire();
        if (LocalDateTime.now().isAfter(expire)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Refresh token expired");
        }

        AccountEntity account = accountService
                .findById(token.getAccountId())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        token.setName(UUID.randomUUID());
        token.setExpire(LocalDateTime.now().plusDays(REFRESH_TOKEN_EXPIRE_DAYS));
        refreshTokenService.updateToken(token);

        String jwt = jwtUtil.createJwt(account.getId());

        return AuthResponse.builder()
                .accessToken(jwt)
                .refreshToken(token.getName().toString())
                .build();
    }
}

package ru.onko.service;

import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenService {

    UUID createToken(RefreshTokenEntity refreshToken);

    Optional<RefreshTokenEntity> findTokenByName(UUID name);

    void updateToken(RefreshTokenEntity refreshToken);

    Optional<RefreshTokenEntity> findTokenByAccountId(UUID id);

    void deleteTokenByAccountId(UUID id);
}

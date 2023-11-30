package ru.onko.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;
import ru.onko.repository.jooq.RefreshTokenRepository;
import ru.onko.service.RefreshTokenService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public UUID createToken(RefreshTokenEntity refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public Optional<RefreshTokenEntity> findTokenByName(UUID name) {
        return refreshTokenRepository.findByName(name);
    }

    @Override
    public void updateToken(RefreshTokenEntity refreshToken) {
        refreshTokenRepository.update(refreshToken);
    }

    @Override
    public Optional<RefreshTokenEntity> findTokenByAccountId(UUID id) {
        return refreshTokenRepository.findByAccountId(id);
    }

    @Override
    public void deleteTokenByAccountId(UUID id) {
        refreshTokenRepository.deleteByAccountId(id);
    }
}

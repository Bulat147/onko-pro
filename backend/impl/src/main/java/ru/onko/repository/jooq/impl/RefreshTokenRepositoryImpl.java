package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;
import ru.onko.repository.jooq.RefreshTokenRepository;

import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.Tables.REFRESH_TOKEN_ENTITY;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {

    private final DSLContext dsl;

    @Override
    public Optional<RefreshTokenEntity> findByName(UUID name) {
        return dsl.selectFrom(REFRESH_TOKEN_ENTITY)
                .where(REFRESH_TOKEN_ENTITY.NAME.eq(name))
                .fetchOptionalInto(RefreshTokenEntity.class);
    }

    @Override
    public void deleteByAccountId(UUID id) {
        dsl.delete(REFRESH_TOKEN_ENTITY)
                .where(REFRESH_TOKEN_ENTITY.ACCOUNT_ID.eq(id))
                .execute();
    }

    @Override
    public Optional<RefreshTokenEntity> findByAccountId(UUID id) {
        return dsl.selectFrom(REFRESH_TOKEN_ENTITY)
                .where(REFRESH_TOKEN_ENTITY.ACCOUNT_ID.eq(id))
                .fetchOptionalInto(RefreshTokenEntity.class);
    }

    @Override
    public UUID save(RefreshTokenEntity refreshToken) {
        return dsl.insertInto(REFRESH_TOKEN_ENTITY)
                .set(dsl.newRecord(REFRESH_TOKEN_ENTITY, refreshToken))
                .returning()
                .fetchOne(REFRESH_TOKEN_ENTITY.ID);
    }

    @Override
    public Optional<RefreshTokenEntity> findById(UUID id) {
        return dsl.selectFrom(REFRESH_TOKEN_ENTITY)
                .where(REFRESH_TOKEN_ENTITY.ID.eq(id))
                .fetchOptionalInto(RefreshTokenEntity.class);
    }

    @Override
    public RefreshTokenEntity update(RefreshTokenEntity refreshToken) {
        return dsl.update(REFRESH_TOKEN_ENTITY)
                .set(dsl.newRecord(REFRESH_TOKEN_ENTITY, refreshToken))
                .where(REFRESH_TOKEN_ENTITY.ID.eq(refreshToken.getId()))
                .returning()
                .fetchOneInto(RefreshTokenEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(REFRESH_TOKEN_ENTITY)
                .where(REFRESH_TOKEN_ENTITY.ID.eq(id))
                .execute();
    }
}

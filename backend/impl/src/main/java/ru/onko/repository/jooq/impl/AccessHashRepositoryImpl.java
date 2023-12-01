package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.pojos.AccessHashEntity;
import ru.onko.repository.jooq.AccessHashRepository;

import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.AccessHash.ACCESS_HASH_ENTITY;

@Repository
@RequiredArgsConstructor
public class AccessHashRepositoryImpl implements AccessHashRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(AccessHashEntity entity) {
        return dsl.insertInto(ACCESS_HASH_ENTITY)
                .set(dsl.newRecord(ACCESS_HASH_ENTITY, entity))
                .returning()
                .fetchOne(ACCESS_HASH_ENTITY.ID);
    }

    @Override
    public Optional<AccessHashEntity> findById(UUID id) {
        return dsl.selectFrom(ACCESS_HASH_ENTITY)
                .where(ACCESS_HASH_ENTITY.ID.eq(id))
                .fetchOptionalInto(AccessHashEntity.class);
    }

    @Override
    public AccessHashEntity update(AccessHashEntity accessHash) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(ACCESS_HASH_ENTITY)
                .where(ACCESS_HASH_ENTITY.ID.eq(id))
                .execute();
    }
}

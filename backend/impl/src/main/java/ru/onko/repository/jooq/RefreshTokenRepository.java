package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, UUID> {

    Optional<RefreshTokenEntity> findByName(UUID name);

    void deleteByAccountId(UUID id);

    Optional<RefreshTokenEntity> findByAccountId(UUID id);
}

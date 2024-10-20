package ru.onko.repository.jooq;

import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {

    List<AccountRole> findRolesById(UUID id);

    Optional<AccountEntity> findByEmail(String email);
}

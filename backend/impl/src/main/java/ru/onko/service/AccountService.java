package ru.onko.service;

import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    Optional<AccountEntity> findByEmail(String email);

    List<AccountRole> findRolesById(UUID id);

    Optional<AccountEntity> findById(UUID id);
}

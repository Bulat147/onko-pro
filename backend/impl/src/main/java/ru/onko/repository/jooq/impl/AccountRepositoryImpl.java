package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.repository.jooq.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.Account.ACCOUNT_ENTITY;
import static ru.onko.model.jooq.tables.AccountRoles.ACCOUNT_ROLES_ENTITY;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final DSLContext dsl;

    @Override
    public List<AccountRole> findRolesById(UUID id) {
        return dsl.selectFrom(ACCOUNT_ROLES_ENTITY)
                .where(ACCOUNT_ROLES_ENTITY.ACCOUNT_ID.eq(id))
                .fetch(ACCOUNT_ROLES_ENTITY.ACCOUNT_ROLE);
    }

    @Override
    public UUID save(AccountEntity account) {
        return dsl.insertInto(ACCOUNT_ENTITY)
                .set(dsl.newRecord(ACCOUNT_ENTITY, account))
                .returning()
                .fetchOne(ACCOUNT_ENTITY.ID);
    }

    @Override
    public Optional<AccountEntity> findById(UUID id) {
        return dsl.selectFrom(ACCOUNT_ENTITY)
                .where(ACCOUNT_ENTITY.ID.eq(id))
                .fetchOptionalInto(AccountEntity.class);
    }

    @Override
    public AccountEntity update(AccountEntity account) {
        return dsl.update(ACCOUNT_ENTITY)
                .set(dsl.newRecord(ACCOUNT_ENTITY, account))
                .where(ACCOUNT_ENTITY.ID.eq(account.getId()))
                .returning()
                .fetchOneInto(AccountEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(ACCOUNT_ENTITY)
                .where(ACCOUNT_ENTITY.ID.eq(id))
                .execute();
    }
}

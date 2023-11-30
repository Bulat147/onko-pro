package ru.onko.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.repository.jooq.AccountRepository;
import ru.onko.service.AccountService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Optional<AccountEntity> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public List<AccountRole> findRolesById(UUID id) {
        return accountRepository.findRolesById(id);
    }

    @Override
    public Optional<AccountEntity> findById(UUID id) {
        return accountRepository.findById(id);
    }
}

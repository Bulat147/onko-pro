package ru.onko.service;

import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.AccountSignUpRequest;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    UUID createAccount(AccountSignUpRequest request, MultipartFile photo);

    Optional<AccountEntity> findByEmail(String email);

    List<AccountRole> findRolesById(UUID id);

    Optional<AccountEntity> findById(UUID id);
}

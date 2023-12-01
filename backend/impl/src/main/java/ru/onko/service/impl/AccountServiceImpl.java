package ru.onko.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.AccountSignUpRequest;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.enums.Gender;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.repository.jooq.AccountRepository;
import ru.onko.service.AccountService;
import ru.onko.service.PhotoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    private final PhotoService photoService;

    public AccountServiceImpl(AccountRepository accountRepository,
                              @Lazy PasswordEncoder passwordEncoder,
                              PhotoService photoService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.photoService = photoService;
    }

    @Override
    public UUID createAccount(AccountSignUpRequest request, MultipartFile photo) {
        UUID photoId = null;
        if (!(photo == null || photo.getSize() == 0)) {
            photoId = photoService.createPhoto(photo);
        }
        AccountEntity account = AccountEntity.builder()
                .email(request.getEmail())
                .hashPassword(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(Gender.valueOf(request.getGender()))
                .birthDate(request.getBirthDate())
                .photoId(photoId)
                .build();

        return accountRepository.save(account);
    }

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

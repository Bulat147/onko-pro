package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.dto.response.UserResponse;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.repository.jooq.AccountRepository;
import ru.onko.services.UsersService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final AccountRepository accountRepository;
    @Override
    public UserResponse findProfile(UUID userId) {
        AccountEntity account = accountRepository.findById(userId).orElseThrow(() ->
                new NoSuchElementException("Нет такого пользователя"));
        return UserResponse.builder()
                .id(account.getId())
                .birthDate(account.getBirthDate())
                .createdDate(account.getCreatedDate())
                .email(account.getEmail())
                .firstName(account.getFirstName())
                .gender(account.getGender().getLiteral())
                .lastName(account.getLastName())
                .state(account.getState().getLiteral())
                .photoId(account.getPhotoId())
                .updatedDate(account.getUpdatedDate())
                .build();
    }
}

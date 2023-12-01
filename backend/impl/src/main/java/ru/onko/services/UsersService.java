package ru.onko.services;

import ru.onko.dto.response.UserResponse;

import java.util.UUID;

public interface UsersService {

    UserResponse findProfile(UUID userId);
}

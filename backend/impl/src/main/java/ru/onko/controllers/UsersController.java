package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.api.UsersApi;
import ru.onko.dto.request.UserUpdateRequest;
import ru.onko.dto.response.UserResponse;
import ru.onko.dto.response.UserUpdateResponse;
import ru.onko.services.UsersService;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UsersService usersService;
    @Override
    public UserResponse findProfile() {
        return null;
    }

    @Override
    public UserUpdateResponse update(UserUpdateRequest request, MultipartFile newImage) {
        return null;
    }

    @Override
    public void delete() {

    }
}

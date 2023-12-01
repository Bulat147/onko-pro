package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.api.SignUpApi;
import ru.onko.dto.request.AccountSignUpRequest;
import ru.onko.service.AccountService;

@RestController
@RequiredArgsConstructor
public class SignUpController implements SignUpApi {

    private final AccountService accountService;

    @Override
    public void signUp(AccountSignUpRequest request, MultipartFile photo) {
        accountService.createAccount(request, photo);
    }
}

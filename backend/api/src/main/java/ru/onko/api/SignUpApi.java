package ru.onko.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.AccountSignUpRequest;

@RequestMapping("/sign-up")
public interface SignUpApi {

    @PostMapping
    void signUp(@RequestPart AccountSignUpRequest request, @RequestPart(required = false) MultipartFile photo);
}

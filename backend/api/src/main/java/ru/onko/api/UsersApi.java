package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.UserUpdateRequest;
import ru.onko.dto.response.UserResponse;
import ru.onko.dto.response.UserUpdateResponse;

@RequestMapping("/user")
public interface UsersApi {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    UserResponse findProfile();
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    UserUpdateResponse update(@RequestBody UserUpdateRequest request,
                              @RequestParam(required = false) MultipartFile newImage);
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete();

    // confirmEmail
}

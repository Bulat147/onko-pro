package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.AccessLinkGeneratingApi;
import ru.onko.services.AccessLinkGeneratingService;

@RestController
@RequiredArgsConstructor
public class AccessLinkGeneratingController implements AccessLinkGeneratingApi {

    private final AccessLinkGeneratingService service;

    @Override
    public String generateAccessLink() {
        // get user id
        return service.generateAccessLink(null);
    }

    @Override
    public ResponseEntity<?> generateAccessQrCode() {
        // get user id
        return service.generateAccessQrCode(null);
    }
}

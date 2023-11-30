package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.AccessLinkGeneratingApi;
import ru.onko.services.AccessLinkGeneratingService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccessLinkGeneratingController implements AccessLinkGeneratingApi {

    private final AccessLinkGeneratingService service;

    @Override
    public String generateAccessLink() {
        // get user id
        return service.generateAccessLink(UUID.fromString("af3cdf9c-fa0e-42b5-9df9-12c244b879b1"));
    }

    @Override
    public ResponseEntity<?> generateAccessQrCode() {
        // get user id
        return service.generateAccessQrCode(UUID.fromString("af3cdf9c-fa0e-42b5-9df9-12c244b879b1"));
    }
}

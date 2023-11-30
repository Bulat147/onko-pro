package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.AccessLinkGeneratingApi;
import ru.onko.security.util.AuthUtil;
import ru.onko.services.AccessLinkGeneratingService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccessLinkGeneratingController implements AccessLinkGeneratingApi {

    private final AccessLinkGeneratingService service;
    private final AuthUtil authUtil;

    @Override
    public String generateAccessLink() {
        UUID id = authUtil.getAccount().getId();
        return service.generateAccessLink(id);
    }

    @Override
    public ResponseEntity<?> generateAccessQrCode() {
        UUID id = authUtil.getAccount().getId();
        return service.generateAccessQrCode(id);
    }
}

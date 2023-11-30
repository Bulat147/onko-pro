package ru.onko.services;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AccessLinkGeneratingService {
    String generateAccessLink(UUID userId);
    ResponseEntity<?> generateAccessQrCode(UUID userId);

}

package ru.onko.services;

import java.util.UUID;

public interface AccessLinkGeneratingService {
    String generateAccessLink(UUID userId);
    byte[] generateAccessQrCode(UUID userId);

}

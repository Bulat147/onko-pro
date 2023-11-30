package ru.onko.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.onko.services.AccessLinkGeneratingService;

import java.util.UUID;

@Service
public class AccessLinkGeneratingServiceImpl implements AccessLinkGeneratingService {

    @Value("${app.netlink}")
    private String netlink;

    @Override
    public String generateAccessLink(UUID userId) {
        UUID hash = null;
        return netlink + "/" + "note/link/" + hash;
    }

    @Override
    public ResponseEntity<?> generateAccessQrCode(UUID userId) {
        return null;
    }
}

package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/generate")
public interface AccessLinkGeneratingApi {
    @GetMapping("/link")
    @ResponseStatus(HttpStatus.OK)
    String generateAccessLink();
    @GetMapping("/qr")
    ResponseEntity<?> generateAccessQrCode();
}

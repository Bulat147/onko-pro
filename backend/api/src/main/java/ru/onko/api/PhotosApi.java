package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@RequestMapping("/photo")
public interface PhotosApi {
    @GetMapping("/load/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> loadById(@PathVariable UUID id);
}

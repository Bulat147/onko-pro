package ru.onko.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.PhotosApi;

import java.util.UUID;

@RestController
public class PhotosController implements PhotosApi {
    @Override
    public ResponseEntity<?> loadById(UUID id) {
        return null;
    }
}

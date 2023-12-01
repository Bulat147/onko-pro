package ru.onko.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface PhotoService {

    UUID createPhoto(MultipartFile photo);
}

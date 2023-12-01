package ru.onko.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.model.jooq.tables.pojos.PhotoEntity;
import ru.onko.repository.jooq.PhotoRepository;
import ru.onko.service.PhotoService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    private final String photoDir;

    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(@Value("file.photo.dir") String photoDir, PhotoRepository photoRepository) {
        this.photoDir = photoDir;
        this.photoRepository = photoRepository;
    }

    @Override
    public UUID createPhoto(MultipartFile photo) {
        if (photo == null || photo.getSize() == 0) {
            return null;
        }

        String extension = "";
        try {
            extension = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
        } catch (Exception e) {}

        String name;
        do {
            name = UUID.randomUUID() + extension;
        } while (checkExists(new File(photoDir), name));
        File file = new File(name);
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(photo.getBytes());
        } catch (IOException e) {
            log.warn(e.getMessage());
        }

        return photoRepository.save(new PhotoEntity(null, name));
    }

    private boolean checkExists(java.io.File dir, String name) {
        for (java.io.File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile()) {
                if (f.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}

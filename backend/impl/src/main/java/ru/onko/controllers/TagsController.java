package ru.onko.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.TagsApi;
import ru.onko.dto.response.TagResponse;

import java.util.List;
import java.util.UUID;

@RestController
public class TagsController implements TagsApi {
    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<TagResponse> findAll() {
        return null;
    }

    @Override
    public List<TagResponse> findByLink(String hash) {
        return null;
    }
}

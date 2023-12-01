package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.TagsApi;
import ru.onko.dto.response.TagResponse;
import ru.onko.services.TagsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TagsController implements TagsApi {

    private final TagsService tagsService;

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<TagResponse> findAll() {
        return null;
    }

    @Override
    public List<TagResponse> findByLink(UUID hash) {
        return tagsService.findByLink(hash);
    }
}

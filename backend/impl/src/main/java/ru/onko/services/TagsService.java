package ru.onko.services;

import ru.onko.dto.response.TagResponse;

import java.util.List;
import java.util.UUID;

public interface TagsService {
    List<TagResponse> findByLink(UUID hash);
}

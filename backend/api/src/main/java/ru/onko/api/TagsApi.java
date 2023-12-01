package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.onko.dto.response.TagResponse;

import java.util.List;
import java.util.UUID;

@RequestMapping("/tag")
public interface TagsApi {

    // полное удаление
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable UUID id);
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TagResponse> findAll();
    @GetMapping("/link/{hash}")
    @ResponseStatus(HttpStatus.OK)
    List<TagResponse> findByLink(@PathVariable UUID hash);
}

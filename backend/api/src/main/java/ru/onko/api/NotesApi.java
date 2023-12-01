package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.onko.dto.request.*;
import ru.onko.dto.response.NoteCreationResponse;
import ru.onko.dto.response.NoteResponse;
import ru.onko.dto.response.NoteUpdateResponse;

import java.util.List;
import java.util.UUID;

@RequestMapping("/note")
public interface NotesApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    NoteCreationResponse create(@RequestBody NoteCreationRequest request);
    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    NoteUpdateResponse update(@RequestBody NoteUpdateRequest request);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable UUID id);
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    List<NoteResponse> searchByWord(@RequestParam(required = false) UUID tagId,
                                  @RequestParam(required = false) List<UUID> symptoms,
                                  @RequestParam String word);
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<NoteResponse> findAll();
    @PostMapping("/tags")
    @ResponseStatus(HttpStatus.OK)
    NoteResponse addTags(@RequestBody NoteTagsAdditionRequest request);
    @DeleteMapping("/tags")
    @ResponseStatus(HttpStatus.ACCEPTED)
    NoteResponse deleteTags(@RequestBody NoteTagsDeletionRequest request);
    @PostMapping("/symptoms")
    @ResponseStatus(HttpStatus.OK)
    NoteResponse addSymptoms(@RequestBody NoteSymptomsAdditionRequest request);
    @DeleteMapping("/symptoms")
    @ResponseStatus(HttpStatus.ACCEPTED)
    NoteResponse deleteSymptoms(@RequestBody NoteSymptomsDeletionRequest request);
    @GetMapping("/link/{hash}")
    @ResponseStatus(HttpStatus.OK)
    List<NoteResponse> findByLink(@PathVariable UUID hash,
                                  @RequestParam(required = false) UUID tagId,
                                  @RequestParam(required = false) List<UUID> symptoms,
                                  @RequestParam(required = false) String word);
}

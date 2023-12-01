package ru.onko.services;

import ru.onko.dto.request.*;
import ru.onko.dto.response.NoteCreationResponse;
import ru.onko.dto.response.NoteResponse;
import ru.onko.dto.response.NoteUpdateResponse;

import java.util.List;
import java.util.UUID;

public interface NotesService {

    List<NoteResponse> findByLink(UUID hash, UUID tagId, List<UUID> symptoms, String word);
    NoteCreationResponse create(UUID userId, NoteCreationRequest request);
    NoteUpdateResponse update(UUID userId, NoteUpdateRequest request);
    void delete(UUID userId, UUID id);
    List<NoteResponse> searchByWord(UUID userId, UUID tagId, List<UUID> symptoms, String word);
    List<NoteResponse> findAll(UUID userId);
    NoteResponse addTags(UUID userId, NoteTagsAdditionRequest request);
    NoteResponse deleteTags(UUID userId, NoteTagsDeletionRequest request);
    NoteResponse addSymptoms(UUID userId, NoteSymptomsAdditionRequest request);
    NoteResponse deleteSymptoms(UUID userId, NoteSymptomsDeletionRequest request);

}

package ru.onko.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.NotesApi;
import ru.onko.dto.request.*;
import ru.onko.dto.response.NoteCreationResponse;
import ru.onko.dto.response.NoteResponse;
import ru.onko.dto.response.NoteUpdateResponse;

import java.util.List;
import java.util.UUID;

@RestController
public class NotesController implements NotesApi {

    @Override
    public NoteCreationResponse create(NoteCreationRequest request) {
        return null;
    }

    @Override
    public NoteUpdateResponse update(NoteUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<NoteResponse> searchByWord(UUID tagId, List<UUID> symptoms, String word) {
        return null;
    }

    @Override
    public List<NoteResponse> findAll() {
        return null;
    }

    @Override
    public NoteResponse addTags(NoteTagsAdditionRequest request) {
        return null;
    }

    @Override
    public NoteResponse deleteTags(NoteTagsDeletionRequest request) {
        return null;
    }

    @Override
    public NoteResponse addSymptoms(NoteSymptomsAdditionRequest request) {
        return null;
    }

    @Override
    public NoteResponse deleteSymptoms(NoteSymptomsDeletionRequest request) {
        return null;
    }

    @Override
    public List<NoteResponse> findByLink(String hash) {
        return null;
    }
}

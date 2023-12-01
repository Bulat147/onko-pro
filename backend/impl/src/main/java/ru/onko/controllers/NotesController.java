package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.NotesApi;
import ru.onko.dto.request.*;
import ru.onko.dto.response.NoteCreationResponse;
import ru.onko.dto.response.NoteResponse;
import ru.onko.dto.response.NoteUpdateResponse;
import ru.onko.security.util.AuthUtil;
import ru.onko.services.NotesService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NotesController implements NotesApi {

    private final NotesService notesService;
    private final AuthUtil authUtil;

    @Override
    public NoteCreationResponse create(NoteCreationRequest request) {
        return notesService.create(authUtil.getAccount().getId(), request);
    }

    @Override
    public NoteUpdateResponse update(NoteUpdateRequest request) {
        return notesService.update(authUtil.getAccount().getId(), request);
    }

    @Override
    public void delete(UUID id) {
        notesService.delete(authUtil.getAccount().getId(), id);
    }

    @Override
    public List<NoteResponse> searchByWord(UUID tagId, List<UUID> symptoms, String word) {
        return notesService.searchByWord(authUtil.getAccount().getId(),
                tagId, symptoms, word);
    }

    @Override
    public List<NoteResponse> findAll() {
        return notesService.findAll(authUtil.getAccount().getId());
    }

    @Override
    public NoteResponse addTags(NoteTagsAdditionRequest request) {
        return notesService.addTags(authUtil.getAccount().getId(), request);
    }

    @Override
    public NoteResponse deleteTags(NoteTagsDeletionRequest request) {
        return notesService.deleteTags(authUtil.getAccount().getId(), request);
    }

    @Override
    public NoteResponse addSymptoms(NoteSymptomsAdditionRequest request) {
        return notesService.addSymptoms(authUtil.getAccount().getId(), request);
    }

    @Override
    public NoteResponse deleteSymptoms(NoteSymptomsDeletionRequest request) {
        return notesService.deleteSymptoms(authUtil.getAccount().getId(), request);
    }

    @Override
    public List<NoteResponse> findByLink(UUID hash, UUID tagId, List<UUID> symptoms, String word) {
        return notesService.findByLink(hash, tagId, symptoms, word);
    }


}

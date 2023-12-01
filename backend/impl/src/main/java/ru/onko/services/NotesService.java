package ru.onko.services;

import ru.onko.dto.response.NoteResponse;

import java.util.List;
import java.util.UUID;

public interface NotesService {

    List<NoteResponse> findByLink(UUID hash, UUID tagId, List<UUID> symptoms, String word);
}

package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.dto.response.NoteResponse;
import ru.onko.exceptions.AccessHashExpiresException;
import ru.onko.exceptions.PermissionError;
import ru.onko.model.jooq.tables.pojos.AccessHashEntity;
import ru.onko.model.jooq.tables.pojos.NoteTagEntity;
import ru.onko.model.jooq.tables.pojos.SymptomEntity;
import ru.onko.repository.jooq.AccessHashRepository;
import ru.onko.repository.jooq.NoteRepository;
import ru.onko.repository.jooq.NoteTagRepository;
import ru.onko.repository.jooq.SymptomRepository;
import ru.onko.services.NotesService;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {

    private final AccessHashRepository accessHashRepository;
    private final NoteTagRepository noteTagRepository;
    private final SymptomRepository symptomRepository;
    private final NoteRepository noteRepository;

    @Override
    public List<NoteResponse> findByLink(UUID hash, UUID tagId, List<UUID> symptoms, String word) {
        AccessHashEntity accessHash = accessHashRepository.findById(hash).orElseThrow(() ->
                new NoSuchElementException("Данной ссылки не существует"));
        if (accessHash.getExpiresDate().isBefore(LocalDateTime.now())) {
            throw new AccessHashExpiresException("Данная ссылка выгорела");
        }
        UUID userId = accessHash.getUserId();
        if (userId == null) {
            throw new NoSuchElementException("Нет маппинга userId на этот линк");
        }
        NoteTagEntity noteTag = noteTagRepository.findById(tagId).orElse(null);
        if(noteTag != null && !noteTag.getAccountId().equals(userId)) {
            throw new PermissionError("Нет доступа к данному тегу");
        }
        List<SymptomEntity> symptomEntities;
        if (symptoms != null) {
            symptomEntities = symptoms.stream().map((id) -> {
                        SymptomEntity entity = symptomRepository.findById(id).orElseThrow(() ->
                                new NoSuchElementException("Нет такого симптома"));
                        if (!entity.getAccountId().equals(userId)) {
                            throw new PermissionError("Нет доступа к данному симптому");
                        }
                        return entity;
                    }
            ).toList();
        } else {
            symptomEntities = new ArrayList<>();
        }
        return noteRepository.searchByAccountId(userId).stream()
                .filter(entity ->
                    noteTag == null || noteRepository.findTagsById(entity.getId()).contains(noteTag)
                ).filter(entity ->
                    symptomEntities.isEmpty() || new HashSet<>(noteRepository.findSymptomsById(entity.getId()))
                        .containsAll(symptomEntities)
                ).filter(entity ->
                    word == null || word.isEmpty() || entity.getName().contains(word) || entity.getTreatment().contains(word)
                            || entity.getContent().contains(word)
                ).map(entity -> NoteResponse.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .treatment(entity.getTreatment())
                        .content(entity.getContent())
                        .creation(entity.getCreatedDate())
                        .userId(entity.getAccountId())
                        .symptoms(noteRepository.findSymptomsById(entity.getId()).stream()
                                .map(SymptomEntity::getId)
                                .toList())
                        .tags(noteRepository.findTagsById(entity.getId()).stream()
                                .map(NoteTagEntity::getId)
                                .toList())
                        .build())
                .toList();
    }
}

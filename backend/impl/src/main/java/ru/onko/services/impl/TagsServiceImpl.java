package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.dto.response.TagResponse;
import ru.onko.exceptions.AccessHashExpiresException;
import ru.onko.model.jooq.tables.pojos.AccessHashEntity;
import ru.onko.repository.jooq.AccessHashRepository;
import ru.onko.repository.jooq.NoteTagRepository;
import ru.onko.services.TagsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService {

    private final AccessHashRepository accessHashRepository;
    private final NoteTagRepository tagRepository;
    @Override
    public List<TagResponse> findByLink(UUID hash) {
        AccessHashEntity accessHash = accessHashRepository.findById(hash).orElseThrow(() ->
                new NoSuchElementException("Данной ссылки не существует"));
        if (accessHash.getExpiresDate().isBefore(LocalDateTime.now())) {
            throw new AccessHashExpiresException("Данная ссылка выгорела");
        }
        UUID userId = accessHash.getUserId();
        if (userId == null) {
            throw new NoSuchElementException("Нет маппинга userId на этот линк");
        }
        return tagRepository.findByUserId(userId).stream()
                .map(entity ->
                    TagResponse.builder()
                            .tagId(entity.getId())
                            .name(entity.getName())
                            .build()
                ).toList();
    }
}

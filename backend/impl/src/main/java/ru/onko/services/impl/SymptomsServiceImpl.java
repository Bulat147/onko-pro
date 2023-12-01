package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onko.dto.response.SymptomResponse;
import ru.onko.exceptions.AccessHashExpiresException;
import ru.onko.model.jooq.tables.pojos.AccessHashEntity;
import ru.onko.repository.jooq.AccessHashRepository;
import ru.onko.repository.jooq.SymptomRepository;
import ru.onko.services.SymptomsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SymptomsServiceImpl implements SymptomsService {

    private final AccessHashRepository accessHashRepository;
    private final SymptomRepository symptomRepository;

    @Override
    public List<SymptomResponse> findByLink(UUID hash) {
        AccessHashEntity accessHash = accessHashRepository.findById(hash).orElseThrow(() ->
                new NoSuchElementException("Данной ссылки не существует"));
        if (accessHash.getExpiresDate().isBefore(LocalDateTime.now())) {
            throw new AccessHashExpiresException("Данная ссылка выгорела");
        }
        UUID userId = accessHash.getUserId();
        if (userId == null) {
            throw new NoSuchElementException("Нет маппинга userId на этот линк");
        }
        return symptomRepository.findByUserId(userId).stream()
                .map(entity ->
                        SymptomResponse.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .build())
                .toList();
    }
}

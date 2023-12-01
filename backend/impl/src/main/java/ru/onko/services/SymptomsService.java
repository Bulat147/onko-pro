package ru.onko.services;

import ru.onko.dto.response.SymptomResponse;

import java.util.List;
import java.util.UUID;

public interface SymptomsService {
    List<SymptomResponse> findByLink(UUID hash);
}

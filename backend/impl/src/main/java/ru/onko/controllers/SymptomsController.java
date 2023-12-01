package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.SymptomsApi;
import ru.onko.dto.response.SymptomResponse;
import ru.onko.services.SymptomsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SymptomsController implements SymptomsApi {

    private final SymptomsService symptomsService;

    @Override
    public void disableSymptom(UUID id) {

    }

    @Override
    public List<SymptomResponse> findAll() {
        return null;
    }

    @Override
    public List<SymptomResponse> findByLink(UUID hash) {
        return symptomsService.findByLink(hash);
    }
}

package ru.onko.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.onko.api.SymptomsApi;
import ru.onko.dto.response.SymptomResponse;

import java.util.List;
import java.util.UUID;

@RestController
public class SymptomsController implements SymptomsApi {
    @Override
    public void disableSymptom(UUID id) {

    }

    @Override
    public List<SymptomResponse> findAll() {
        return null;
    }
}

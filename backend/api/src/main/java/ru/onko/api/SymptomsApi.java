package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.onko.dto.response.SymptomResponse;

import java.util.List;
import java.util.UUID;

@RequestMapping("/symptom")
public interface SymptomsApi {
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void disableSymptom(@PathVariable UUID id); // enable при создании такого же реализуется копанием в бд
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<SymptomResponse> findAll();
    @GetMapping("/link/{hash}")
    @ResponseStatus(HttpStatus.OK)
    List<SymptomResponse> findByLink(@PathVariable UUID hash);
}

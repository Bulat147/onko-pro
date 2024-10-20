package ru.onko.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteUpdateRequest {

    @NotNull
    private UUID id;
    private String name;
    private String content;
    private String treatment;

}

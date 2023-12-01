package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteCreationResponse {

    private UUID id;
    private String name;
    private LocalDateTime creation;
    private UUID userId;
    private String content;
    private String treatment;

}

package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteResponse {

    private UUID id;
    private String name;
    private LocalDateTime creation;
    private UUID userId;
    private String content;
    private String treatment;
    private List<UUID> tags;
    private List<UUID> symptoms;

}

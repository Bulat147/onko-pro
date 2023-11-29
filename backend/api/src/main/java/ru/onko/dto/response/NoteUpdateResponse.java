package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteUpdateResponse {

    private UUID id;
    private String name;
    private Date creation;
    private UUID userId;
    private String content;
    private String treatment;


}

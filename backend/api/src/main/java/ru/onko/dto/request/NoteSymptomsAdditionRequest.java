package ru.onko.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoteSymptomsAdditionRequest {

    private UUID noteId;
    private List<UUID> existingSymptomsId;
    private List<String> newSymptomsName;

}

package ru.onko.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteCreationRequest {

    private String name;
    private Date creation;
    private String content;
    private String treatment;
    private List<UUID> existingTagsId;
    private List<String> newTagsName;
    private List<UUID> existingSymptomsId;
    private List<String> newSymptomsName;
}

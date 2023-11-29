package ru.onko.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteTagsAdditionRequest {

    private UUID noteId;
    private List<UUID> existingTagsId;
    private List<String> newTagsName;

}

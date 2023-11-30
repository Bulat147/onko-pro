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
public class ArticleUpdatingRequest {

    private UUID id;
    private String title;
    private String content;
    private String position;
    private List<UUID> deletingPhotosId;

}

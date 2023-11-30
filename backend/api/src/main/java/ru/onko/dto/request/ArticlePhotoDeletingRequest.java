package ru.onko.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArticlePhotoDeletingRequest {

    private UUID articleId;
    private UUID photoId;
}

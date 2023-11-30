package ru.onko.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ArticlePhotoAdditionRequest {

    private UUID articleId;
    private UUID photoID;
}

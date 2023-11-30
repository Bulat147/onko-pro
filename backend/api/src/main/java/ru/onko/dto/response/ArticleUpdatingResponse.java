package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleUpdatingResponse {

    private UUID id;
    private String title;
    private String content;
    private String position;


}
